package communal;

/**
 * 结果类
 * @author Administrator
 *
 */
public class Result {

	private String code;
	private String message;
	private Object data;

	public Result() {

		this.code = "0000";
		this.message = "";
		this.data = null;
	}

	public Result(String message) {

		this();
		this.message = message;
	}

	public Result(String code, String message) {

		this();
		this.code = code;
		this.message = message;
	}

	public Result(String message, Object data) {

		this();
		this.message = message;
		this.data = data;
	}

	public Result(String code, String message, Object data) {
		this();
		this.message = message;
		this.data = data;
		this.code = code;
	}
}
