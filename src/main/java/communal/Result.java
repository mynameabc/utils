package communal;

import lombok.Data;

/**
 * 结果类
 * @author Administrator
 *
 */
@Data
public class Result {

	private String code;
	private boolean success;
	private String message;
	private Object data;

	public Result() {

		this.code = "0000";
		this.success = true;
		this.message = "";
		this.data = null;
	}

	public Result(boolean success, String message) {

		this();
		this.success = success;
		this.message = message;
	}

	public Result(String code, String message) {

		this();
		this.code = code;
		this.message = message;
	}

	public Result(boolean success, String message, Object data) {

		this();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public Result(String code, String message, Object data) {
		this();
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public Result(String code, boolean success, String message, Object data) {
		this();
		this.success = success;
		this.message = message;
		this.data = data;
		this.code = code;
	}
}
