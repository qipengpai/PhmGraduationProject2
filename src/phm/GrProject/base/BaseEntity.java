package phm.GrProject.base;


import phm.GrProject.tool.DateUtil;
import phm.GrProject.tool.RandomUtil;


public class BaseEntity {
	public static RandomUtil ran;
	public static DateUtil date;
	public Object context;
	public Object getContext() {
		return context;
	}
	public void setContext(Object context) {
		this.context = context;
	}
	
	
}
