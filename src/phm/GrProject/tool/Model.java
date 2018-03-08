package phm.GrProject.tool;

public class Model{
	private int nowpage;
	private int totalpage;
	private int error = 200;
	private String msg = "success";
	private Object obj;

	public Model() {
	}

	public Model(Object retobj) {
		this.setObj(retobj);
	}

	public Model(int errorcode) {
		if (errorcode == 500) {
			this.error = 500;
			this.msg = "error";
		}
	}

	public Model(int errorcode, Object obj) {
		this.error = errorcode;
		this.obj = obj;
	}

	public Model(int errorcode, String msg) {
		this.error = errorcode;
		this.msg = msg;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	
}
