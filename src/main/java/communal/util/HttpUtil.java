package communal.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

public class HttpUtil {

    private final static String CHARSET = "UTF-8";

    private final static String GET = "GET";

    private final static String POST = "POST";

    /**
     * Get Http请求
     * @param requestUrl 请求的地址
     * @param parameter 参数
     * @return 返回值
     */
    public static String getHttp(String requestUrl, String parameter) {
        return httpRequest(requestUrl, GET, parameter);
    }

    /**
     * Get Https请求
     * @param requestUrl 请求的地址
     * @param parameter 参数
     * @return 返回值
     */
    public static String getHttps(String requestUrl, String parameter) {
        return httpsRequest(requestUrl, GET, parameter);
    }

    /**
     * Post Http请求
     * @param requestUrl 请求的地址
     * @param parameter 参数
     * @return 返回值
     */
    public static String postHttp(String requestUrl, String parameter) {
        return httpRequest(requestUrl, POST, parameter);
    }

    /**
     * Post Https请求
     * @param requestUrl 请求的地址
     * @param parameter 参数
     * @return 返回值
     */
    public static String postHttps(String requestUrl, String parameter) {
        return httpsRequest(requestUrl, POST, parameter);
    }

    /**
     * 发起https请求并返回结果
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式(GET, POST)
     * @param outputStr     提交的数据
     * @return String
     */
    private static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setRequestProperty("accept", "*/*");
            httpUrlConn.setRequestProperty("connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpUrlConn.setRequestProperty("content-type", "application/json; charset=utf-8");
            httpUrlConn.setDoOutput(true);
            return send(httpUrlConn, requestMethod, outputStr, buffer);
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {
            System.out.println("https request error:{}" + e);
        }
        return buffer.toString();
    }

    /**
     * 发起https请求并返回结果
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式(GET, POST)
     * @param outputStr     提交的数据
     * @return String
     */
    private static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            return send(httpUrlConn, requestMethod, outputStr, buffer);
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {
            System.out.println("https request error:{}" + e);
        }
        return null;
    }

    private static String send(HttpsURLConnection httpUrlConn, String requestMethod, String outputStr, StringBuffer buffer) {

        try {
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式(GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式, 防止中文乱码
                outputStream.write(outputStr.getBytes(CHARSET));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CHARSET);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 回收资源
            {
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                httpUrlConn.disconnect();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
