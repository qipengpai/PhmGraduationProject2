package phm.GrProject.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phm.GrProject.entity.Landlord;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.OldHouseData;
import phm.GrProject.service.LandlordService;
import phm.GrProject.service.OldHouseService;
import phm.GrProject.system.ActionUrl;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import java.util.List;

@Controller
public class OldHouseAction {
    @Autowired
    private OldHouseService oldHouseService;

    @Autowired
    private LandlordService landlordService;

    /***
     * phm
     * 查询所有二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_OLDHOUSE,method = RequestMethod.POST)
    public Model getALLOldHouse(OldHouseData oldHouseData){
        if (ParaClick.clickString(oldHouseData.getNowPage())) {
            oldHouseData.setNowPage("1");
        }
        Model model=new Model();
        int num= oldHouseService.getTotalsize(oldHouseData);
        List<OldHouse> list= oldHouseService.getAllOldHouse(oldHouseData);
        if(!ParaClick.clickList(list)){ return new Model(500,"查詢失敗"); }
        for (int i = 0; i <list.size(); i++) {
            Landlord landlord= landlordService.get(list.get(i).getLandladyId());
            if(landlord==null){
                return new Model(500,"房東爲空");
            }
            list.get(i).setContext(landlord.getName());
        }
        model.setError(200);
        model.setNowpage(Integer.parseInt(oldHouseData.getNowPage()));
        model.setTotalpage((num  +  10  - 1) / 10);
        model.setObj(list);
        return model;
    }
    /***
     * phm
     * 根据id查询所有二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_OLDHOUSE_BYID,method = RequestMethod.POST)
    public Model getALLOldHouseByid(OldHouseData oldHouseData){
        if(oldHouseData.getId()==null){
            return new Model(500,"id为空");
        }
        OldHouse oldHouse= oldHouseService.getOldHouseById(oldHouseData);
        if(oldHouse==null){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,oldHouse);
    }
    /***
     * phm
     * 新增二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.ADD_OLDHOUSES,method = RequestMethod.POST)
    public Model addOldHouse(OldHouseData oldHouseData){
        if(ParaClick.clickString( oldHouseData.getArea())){
            return new Model(500, " 面积非空");
        }
        if(ParaClick.clickString( oldHouseData.getLandladyId())){
            return new Model(500, " 房东为空");
        }
        if(ParaClick.clickString( oldHouseData.getOldHouse())){
            return new Model(500, " 图片为空");
        }
        if(ParaClick.clickString( oldHouseData.getOldHouseAddress())){
            return new Model(500, " 地址为空");
        }
        if(ParaClick.clickString( oldHouseData.getOldHouseFloor())){
            return new Model(500, "楼层为空");
        }
        if(ParaClick.clickString(oldHouseData.getOldHouseMoney())){
            return new Model(500, "价格为空");
        }
        if(ParaClick.clickString(oldHouseData.getOldHouseName())){
            return new Model(500, " 房屋名称为空");
        }
        if(ParaClick.clickString(oldHouseData.getOldHouseJie())){
            return new Model(500, " 房屋介绍为空");
        }
        if(ParaClick.clickString( oldHouseData.getOldHouseType())){
            return new Model(500, "类型为空");
        }
        if(ParaClick.clickString(oldHouseData.getOldHouseYear())){
            return new Model(500, "年限");
        }
        if(ParaClick.clickString(oldHouseData.getZxstate())){
            return new Model(500, " 装修状态为空");
        }
        boolean oldHouse= oldHouseService.addOldHouse(oldHouseData);
        if(!oldHouse){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,"查询成功");
    }
    /***
     * phm
     * 修改二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.UPDATE_OLDHOUSE,method = RequestMethod.POST)
    public Model updateOldHouse(OldHouseData oldHouseData){
        if(ParaClick.clickString( oldHouseData.getId())){
            return new Model(500, " id 为空");
        }
        boolean oldHouse= oldHouseService.updateOldHouse(oldHouseData);
        if(!oldHouse){
            return new Model(500,"修改失敗");
        }
        return new Model(200,"修改成功");
    }
    /***
     * phm
     * 删除二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.DELETE_OLDHOUSE,method = RequestMethod.POST)
    public Model deleteOldHouseByid(OldHouseData oldHouseData){
        if(oldHouseData.getId()==null){
            return new Model(500,"id为空");
        }
        boolean flag= oldHouseService.deleteOldHouseById(oldHouseData);
        if(!flag){
            return new Model(500,"删除失敗");
        }
        return new Model(200,"删除成功");
    }


    /***
     * phm
     * 网页端查询所有二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.PC_GET_OLDHOUSE,method = RequestMethod.POST)
    public Model getALLPCOldHouse(){
        Model model=new Model();
        List<OldHouse> list= oldHouseService.getAllPCOldHouse();
        if(!ParaClick.clickList(list)){ return new Model(500,"查詢失敗"); }
        for (int i = 0; i <list.size(); i++) {
            Landlord landlord= landlordService.get(list.get(i).getLandladyId());
            if(landlord==null){
                return new Model(500,"房東爲空");
            }
            list.get(i).setContext(landlord.getName());
        }
        model.setError(200);
        model.setObj(list);
        return model;
    }
    /***
     * phm
     * 网页端查询所有热门二手房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.PC_GET_HOT_OLDHOUSE,method = RequestMethod.POST)
    public Model getALLPCHotOldHouse(){
        Model model=new Model();
        List<OldHouse> list= oldHouseService.getAllPCHotOldHouse();
        if(!ParaClick.clickList(list)){ return new Model(500,"查詢失敗"); }
        for (int i = 0; i <list.size(); i++) {
            Landlord landlord= landlordService.get(list.get(i).getLandladyId());
            if(landlord==null){
                return new Model(500,"房東爲空");
            }
            list.get(i).setContext(landlord.getName());
        }
        model.setError(200);
        model.setObj(list);
        return model;
    }
}

