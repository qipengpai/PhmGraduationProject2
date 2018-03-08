package phm.GrProject.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phm.GrProject.entity.Administrators;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entityvo.KeHuData;
import phm.GrProject.service.KeHuService;
import phm.GrProject.system.ActionUrl;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KeHuAction {

    @Autowired
    private KeHuService keHuService;

    /**
     * phm
     * 用戶登陸
     * */
    @ResponseBody
    @RequestMapping(value = ActionUrl.KEHU_LOGIN, method = RequestMethod.POST)
    public Model login(HttpServletRequest request, String username,
                       String adminPwd, String vcode) {
        Model model = new Model();
        if (ParaClick.clickString(username)) {
            return new Model(500, "请输入用户名");
        }
        if (ParaClick.clickString(adminPwd)) {
            return new Model(500, "请输入密码");
        }

        List<KeHu> list = keHuService.kehulogin(username, adminPwd);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "登录失败 ");
        }
        model.setError(200);
        model.setMsg("登录成功");
        model.setObj(list.get(0));
        request.getSession().setAttribute("kehuInfo", model.getObj());
        request.getSession().setMaxInactiveInterval(-1);
        return model;
    }
    /**
     * phm
     * 用户祖册
     * */
    @ResponseBody
    @RequestMapping(value=ActionUrl.KEHU_ZUCE,method = RequestMethod.POST)
    public Model register(HttpServletRequest request, KeHuData keHuData){
        if(ParaClick.clickString(keHuData.getAdminName())){
            return new Model(500, "用户名错误");
        }
        if(ParaClick.clickString(keHuData.getAdminPwd())){
            return new Model(500, "用户密码错误");
        }
        boolean flag= keHuService.saveKeHu(keHuData);
        if(!flag){
            return new Model(500,"注冊失敗");
        }
        return new Model(200,"注冊成功");
    }

    /**
     * phm
     * 查询所有用户
     * */
    @ResponseBody
    @RequestMapping(value=ActionUrl.GET_ALLKEHUINFO,method = RequestMethod.POST)
    public Model getallkehu(KeHuData keHuData){
        Model model=new Model();
        if(ParaClick.clickString(keHuData.getNowPage())){
            keHuData.setNowPage("1");
        }
        int num= keHuService.getTotalsize(keHuData);
        List<KeHu> list= keHuService.getAllKeHu(keHuData);
        if(!ParaClick.clickList(list)){
            return new Model(500,"查询失败 ");
        }
        model.setError(200);
        model.setNowpage(Integer.parseInt(keHuData.getNowPage()));
        model.setTotalpage((num  +  10  - 1) / 10);
        model.setObj(list);
        return model;
    }
    /**
     * phm
     * 根据id查询客户信息
     * */
    @ResponseBody
    @RequestMapping(value=ActionUrl.GET_KEHUINFO_BYID,method = RequestMethod.POST)
    public Model getkehubyid(KeHuData keHuData){

        if(ParaClick.clickString(keHuData.getId())){
            return new Model(500,"id为空 ");
        }
        KeHu kehu= keHuService.getKeHuById(keHuData);
        if(kehu==null){
            return new Model(500,"查询失败 ");
        }
        return new Model(200,kehu);
    }
    /**
     * phm
     * 用户完善信息
     * */
    @ResponseBody
    @RequestMapping(value=ActionUrl.CONFIRM_KEHUINFO,method = RequestMethod.POST)
    public Model confirmKuHuInfo(KeHuData keHuData){
        if(ParaClick.clickString(keHuData.getId())){
            return new Model(500,"id为空 ");
        }
        boolean flag= keHuService.updateKuHuInfo(keHuData);
        if(!flag){
            return new Model(500,"修改失败 ");
        }
        return new Model(200,"修改成功");
    }
}
