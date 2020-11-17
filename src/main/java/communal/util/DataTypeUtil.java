package communal.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataTypeUtil {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

    public static boolean isEmpty(JSONObject jsonObject) {
        return null == jsonObject || jsonObject.isEmpty();
    }

    public static boolean isNotEmpty(JSONObject jsonObject) {
        return null != jsonObject && !jsonObject.isEmpty();
    }

    public static void main(String args[]) {

        List s = new ArrayList();
/*        s.add("1");*/

        List t = null;

        System.out.println(DataTypeUtil.isEmpty(s));


        if (DataTypeUtil.isEmpty(s)) {
            System.out.println("object is empty!");
        }

    }
}
