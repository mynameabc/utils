package communal;

import java.util.List;

public class PagerModel {

	private int code = 0;

	private String msg = "";
	
	//记录数
	private long count = 0;
	
	//结果集
	private List<?> data = null;
	
	public PagerModel() {
		
	}
	
	public PagerModel(long total, List<?> list) {
		
		this.count = total;
		this.data = list;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
