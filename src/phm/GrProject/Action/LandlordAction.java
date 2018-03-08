package phm.GrProject.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phm.GrProject.entity.Landlord;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.LandlordData;
import phm.GrProject.entityvo.OldHouseData;
import phm.GrProject.service.LandlordService;
import phm.GrProject.system.ActionUrl;
import phm.GrProject.tool.DateUtil;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import java.util.List;

@Controller
public class LandlordAction {


    @Autowired
    private LandlordService landlordService;

    /***
     * phm
     * 根据id查询房东
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_LANDLORD_BYID,method = RequestMethod.POST)
    public Model getLandlord(LandlordData landlordData){
        if(landlordData.getId()==null){
            return new Model(500,"id为空");
        }
        Landlord landlord= landlordService.getOldHouseById(landlordData);
        if(landlord==null){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,landlord);
    }

    /***
     * phm
     * 查询所有房东
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_ALLLANDLORD,method = RequestMethod.POST)
    public Model getALLLandlord(LandlordData landlordData){
        Model model=new Model();
        if(ParaClick.clickString(landlordData.getNowPage())){
            landlordData.setNowPage("1");
        }
        int num= landlordService.getTotalsize(landlordData);

        List<Landlord> landlord= landlordService.getAllOldHouse(landlordData);
        if(!ParaClick.clickList(landlord)){
            return new Model(500,"查詢失敗");
        }
        for (int i = 0; i <landlord.size() ; i++) {
            landlord.get(i).setContext(DateUtil.dateToTimeStamp(landlord.get(i).getRegisteredDate()));
        }
        model.setError(200);
        model.setNowpage(Integer.parseInt(landlordData.getNowPage()));
        model.setTotalpage((num  +  10  - 1) / 10);
        model.setObj(landlord);
        return model;
    }
    /***
     * phm
     * 新增房东
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.ADD_LANDLORD,method = RequestMethod.POST)
    public Model addLandLord(LandlordData landlordData){
        if(ParaClick.clickString( landlordData.getAge())){
            return new Model(500, " 年龄为空");
        }
        if(ParaClick.clickString( landlordData.getName())){
            return new Model(500, "姓名为空");
        }
        if(ParaClick.clickString( landlordData.getPhone())){
            return new Model(500, " 电话为空");
        }
        if(ParaClick.clickString( landlordData.getSex())){
            return new Model(500, " 性别为空");
        }
        if(ParaClick.clickString( landlordData.getIdCard())){
            return new Model(500, " 身份证号为空");
        }
        boolean flag= landlordService.addLandlord(landlordData);
        if(!flag){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,"");
    }
    /***
     * phm
     * 修改房東
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.UPDATE_LANDLORD,method = RequestMethod.POST)
    public Model updateOldHouse(LandlordData landlordData){
        if(ParaClick.clickString( landlordData.getId())){
            return new Model(500, " id 为空");
        }
        boolean flag= landlordService.updateLandlord(landlordData);
        if(!flag){
            return new Model(500,"修改失敗");
        }
        return new Model(200,"修改成功");
    }
    /***
     * phm
     * 删除房东和他的房子
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.DELETE_LANDLORD,method = RequestMethod.POST)
    public Model deleteLandlord(LandlordData landlordData){
        if(landlordData.getId()==null){
            return new Model(500,"id为空");
        }
        boolean flag= landlordService.deletelandlord(landlordData);
        if(!flag){
            return new Model(500,"删除失敗");
        }
        return new Model(200,"删除成功");
    }
}
