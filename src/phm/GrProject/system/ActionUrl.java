package phm.GrProject.system;

public class ActionUrl {
	
	/*用户登录*/
	public static final String ADMIN_LOGIN="/phm/GraduationProject/login";
	/*获取管理员信息*/
	public static final String GET_ADMIN="/phm/get/GraduationProject/info";
	/*获取管理员信息*/
	public static final String ADMIN_LOGOUT="/phm/GraduationProject/logout";
	/*验证码*/
	public static final String VALIDATECODE="/phm/admin/ValidateCodeServlet";
	/*修改密码*/
	public static final String 	UPDATE_PWD="/phm/admin/updatePwd";


	/*得到所有二手房*/
	public static final String GET_OLDHOUSE="/phm/GraduationProject/get/oldhouse";
	/*根据id得到所有二手房*/
	public static final String GET_OLDHOUSE_BYID="/phm/get/secondHandHouseByid";
	/*修改二手房信息*/
	public static final String UPDATE_OLDHOUSE="/phm/UPDATE/secondHandHouse";
	/*新增二手房信息*/
	public static final String ADD_OLDHOUSES="/phm/adds/second/HandHouse";
	/*新增二手房信息*/
	public static final String DELETE_OLDHOUSE="/phm/delete/secondHandHouse";
	/*网页端得到所有二手房*/
	public static final String PC_GET_OLDHOUSE="/phm/GraduationProject/get/pc/oldhouse";
	/*网页端得到所有热门二手房*/
	public static final String PC_GET_HOT_OLDHOUSE="/phm/GraduationProject/get/pc/hot/oldhouse";


	/*查询所有房东*/
	public static final String GET_ALLLANDLORD="/phm/get/allLandlord";
	/*根据id查询房东*/
	public static final String GET_LANDLORD_BYID="/phm/get/allLandlordById";
	/*增加房东*/
	public static final String ADD_LANDLORD="/phm/add/LandlordInfo";
	/*修改房东信息*/
	public static final String UPDATE_LANDLORD="/phm/update/LandlordInfo";
	/*删除房东信息*/
	public static final String DELETE_LANDLORD="/phm/delete/Landlord";


	/*查询所有新房*/
	public static final String GET_NEWHOUSES="/phm/get/allNewHouse";
	/*根据id查询新房*/
	public static final String GET_NEWHOUSE_BYID="/phm/get/NewHouseById";
	/*增加新房*/
	public static final String ADD_NEWHOUSE="/phm/add/NewHouseInfo";
	/*修改新房信息*/
	public static final String UPDATE_NEWHOUSE="/phm/update/NewHouseInfo";
	/*删除新房信息*/
	public static final String DELETE_NEWHOUSE="/phm/delete/NewHouse";
	/*pc获取新房信息*/
	public static final String GET_PC_NEWHOUSE="/phm/get/pc/NewHouse";
	/*网页端得到所有热门新房*/
	public static final String GET_PC_HOT_NEWHOUSE="/phm/GraduationProject/get/pc/hot/newhouse";


	/*用戶登陸*/
	public static final String KEHU_LOGIN="/phm/kehu/login";
	/*用戶注冊*/
	public static final String KEHU_ZUCE="/phm/kehu/zuces";
	/*完善用戶信息*/
	public static final String CONFIRM_KEHUINFO="/phm/confirm/kehuinfo";
	/*後臺查看所有用戶信息*/
	public static final String GET_ALLKEHUINFO="/phm/get/allkehuinfo";
	/*根据id查询客户*/
	public static final String GET_KEHUINFO_BYID="/phm/get/kehuinfo";
	/*修改客户信息*/
	public static final String UPDATE_KEHUINFO_BYID="/phm/update/kehuinfo";


}


