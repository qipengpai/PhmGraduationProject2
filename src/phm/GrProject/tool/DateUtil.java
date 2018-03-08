package phm.GrProject.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String get_yyyy() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
		return df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
	}
	public static String getdate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	
	public static String getdate_yyyy_MM_dd(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());
	}
	
	public static Date getdate_yyyy_MM_dd_00_00_00(String startDate){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date = null;
		try {
			date = df.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	  public static String dateToStamp(String s){
		  String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        long lt = new Long(s);
	        Date date = new Date(lt);
	        res = simpleDateFormat.format(date);
	     return res;
	    }
	  public static Date dateToStamp2(String s){
		  	String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        long lt = new Long(s);
	        Date date = new Date(lt);
	        res = simpleDateFormat.format(date);
	        Date date2=getdate_yyyy_MM_dd_00_00_00(res);
	        return date2;
	    }
	  public static String dateToTimeStamp(Date date){
			String o=date.toString();
			//System.out.println(o);
			String n=o.substring(0, o.lastIndexOf('.'));
			//System.out.println(n);
	        return n;
	    }
	public static void main(String[] args) {
//		System.out.println(dateToStamp("1508477564000"));
//		System.out.println(dateToStamp2("1508477564000"));
//		//Date date =new Date();
//		System.out.println(getdate_yyyy_MM_dd());
//		GregorianCalendar gc = new GregorianCalendar();
//		  
//		  gc.set(2008, 5, 21);
//		  System.out.println(gc);
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
//		  gc.add(Calendar.DAY_OF_YEAR, 5);
//		  System.out.println(sdf.format(gc.getTime()));
//		  gc.add(Calendar.MONTH, -5);
//		  System.out.println(sdf.format(gc.getTime()));
//		  gc.add(Calendar.YEAR, 5);
//		  System.out.println(sdf.format(gc.getTime()));
//		  gc.add(Calendar.HOUR, 5);
//		  System.out.println(sdf.format(gc.getTime()));
//		  gc.add(Calendar.SECOND, 5);
//		  System.out.println(sdf.format(gc.getTime()));
	}

}
