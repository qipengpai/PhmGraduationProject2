package phm.GrProject.tool;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import phm.GrProject.exception.BusinessException;
import phm.GrProject.exception.ErrorCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤用户登录
 * @author 覃金林
 *
 */
public class AdminListner implements HandlerInterceptor {
	private static int num=0;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		//response.sendRedirect("../login.jsp");  
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("开始过滤");
			Object value=request.getSession().getAttribute("userinfo");
			if(value!=null){
				return true;
				
			}else{
		//		response.sendRedirect("./../xlcr/admin/administratorslogin.do");
			 throw new BusinessException(ErrorCode.NOT_AUTHORIZATION);
			}
	}
}
