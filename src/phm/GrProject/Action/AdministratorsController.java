package phm.GrProject.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phm.GrProject.entity.Administrators;
import phm.GrProject.service.AdministratorsService;
import phm.GrProject.system.ActionUrl;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdministratorsController {

	@Autowired
	private AdministratorsService administratorsService;

	/**
	 * phm
	 * 管理員登陸
	 * */
	@ResponseBody
	@RequestMapping(value = ActionUrl.ADMIN_LOGIN, method = RequestMethod.POST)
	public Model login(HttpServletRequest request, String username,
                       String adminPwd, String vcode) {
		Model model = new Model();
		if (ParaClick.clickString(username)) {
			return new Model(500, "请输入用户名");
		}
		if (ParaClick.clickString(adminPwd)) {
			return new Model(500, "请输入密码");
		}
		try {
			String c = vcode.toLowerCase();
			String svcode = request.getSession().getAttribute("vCode")
					.toString().toLowerCase();
			// String svcode="12345";
			if (c == null || !svcode.equals(c)) {
				return new Model(406, "验证码错误");
			}
		} catch (Exception e) {
			return new Model(406, "验证码错误");
		}

		List<Administrators> list = administratorsService.login(username, adminPwd);
		if (!ParaClick.clickList(list)) {
			return new Model(500, "登录失败 ");
		}
		model.setError(200);
		model.setMsg("登录成功");
		model.setObj(list.get(0));
		request.getSession().setAttribute("userinfo", model.getObj());
		request.getSession().setMaxInactiveInterval(-1);
		return model;
	}
	/*获取管理员信息*/
	@ResponseBody
	@RequestMapping(value=ActionUrl.GET_ADMIN,method = RequestMethod.GET)
	public Model getProvider(String code){
		if(ParaClick.clickString(code)){
			return new Model(500, "识别不到用户");
		}
		List<Administrators> list=administratorsService.getAdmin(code);
		if(null != list&&list.size() !=0){
			Model model=new Model();
			model.setError(200);
			model.setObj(list.get(0));
			return model;
		}else{
			return new Model(404, "未找到用户");
		}
	} 
	/*退出登录*/
	@RequestMapping(value = ActionUrl.ADMIN_LOGOUT, method = RequestMethod.POST)
	public void execute(HttpSession session){
	        session.invalidate();		      
	}

	/**
	 * 修改密码
	 * @param request
	 * @param username
	 * @param userpwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=ActionUrl.UPDATE_PWD,method = RequestMethod.POST)
	public Model updatePwd(HttpSession session,HttpServletRequest request, String username,String userpwd,String newpwd){
		if(ParaClick.clickString(username)){
			return new Model(500, "请输入用户名");
		}
		if(ParaClick.clickString(userpwd)){
			return new Model(500, "请输入密码");
		}
		if(ParaClick.clickString(newpwd)){
			return new Model(500, "请输入密码");
		}
		boolean flag=administratorsService.updatePwd(username,userpwd,newpwd);
		if(!flag){
			return new Model(500, "修改失败");
		}
		return new Model(200, "修改成功 请重新登录");
	}

}
