package communal;

/**
 * 结果类
 * @author Administrator
 *
 */
public class Result {

	private int code;
	private boolean success;
	private String message;
	private Object data;

	public Result() {

		this.code = 0;
		this.success = true;
		this.message = "";
		this.data = null;
	}

	public Result(boolean success, String message) {

		this();
		this.success = success;
		this.message = message;
	}

	public Result(boolean success, String message, Object data) {

		this();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public Result(boolean success, String message, Object data, int code) {

		this();
		this.success = success;
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
