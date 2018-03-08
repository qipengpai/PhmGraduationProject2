package phm.GrProject.system;

public class SystemConfig {

	//短信
	public static final String SendCodeAppkey="key-04ef88e020dd2ccc87221d5bd020cb31";
	public static final String SendCodeHttpUrl="http://sms-api.luosimao.com/v1/send.json";
	public static final String SendCodeMessage(String code){
		return "注册验证码:"+code+"【潮人微游】";
	}
	public static final String SendCodeMessage_update_pwd(String code){
		return "找回密码验证码:"+code+"【潮人微游】";
	}
	//默认头像
	public static final String userimg="http://ox143yv1l.bkt.clouddn.com/20170929145712.jpg";
	//提供商上传文件
	public static final String ProviderFile="/admin/upload/authentication/";
	//游戏图标物理位置
	public static final String Game_Head="/admin/upload/Game/head/";
	//游戏介绍图物理位置
	public static final String Game_Boyd="/admin/upload/Game/body/";
}
