package phm.GrProject.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entity.NewHouse;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.NewHouseData;
import phm.GrProject.entityvo.OldHouseData;
import phm.GrProject.service.NewHouseService;
import phm.GrProject.system.ActionUrl;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NewHouseAction {

    @Autowired
    private NewHouseService newHouseService;

    /***
     * phm
     * 查询所有新房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_NEWHOUSES,method = RequestMethod.POST)
    public Model getALLNewHouse(NewHouseData newHouseData){
        if(ParaClick.clickString(newHouseData.getNowPage())){
            newHouseData.setNowPage("1");
        }
        Model model=new Model();
        int num= newHouseService.getTotalsize(newHouseData);
        List<NewHouse> list= newHouseService.getAllOldHouse(newHouseData);
        if(!ParaClick.clickList(list)){
            return new Model(500,"查詢失敗");
        }
        model.setError(200);
        model.setNowpage(Integer.parseInt(newHouseData.getNowPage()));
        model.setTotalpage((num  +  10  - 1) / 10);
        model.setObj(list);
        return model;
    }

    /***
     * phm
     * 根据id查询所有新房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_NEWHOUSE_BYID,method = RequestMethod.POST)
    public Model getALLNewHouseByid(NewHouseData newHouseData){
        if(newHouseData.getId()==null){
            return new Model(500,"id为空");
        }
        NewHouse newHouse= newHouseService.getNewHouseById(newHouseData);
        if(newHouse==null){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,newHouse);
    }
    /***
     * phm
     * 新增新房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.ADD_NEWHOUSE,method = RequestMethod.POST)
    public Model addOldHouse(NewHouseData newHouseData){
        if(ParaClick.clickString( newHouseData.getArea())){
            return new Model(500, " 面积非空");
        }
        if(ParaClick.clickString( newHouseData.getNewHouseImg())){
            return new Model(500, " 图片为空");
        }
        if(ParaClick.clickString( newHouseData.getNewHouseAddress())){
            return new Model(500, " 地址为空 ");
        }
        if(ParaClick.clickString( newHouseData.getNewHouseFloor())){
            return new Model(500, "楼层为空");
        }
        if(ParaClick.clickString(newHouseData.getNewHouseMoney())){
            return new Model(500, "价格为空");
        }
        if(ParaClick.clickString(newHouseData.getNewHouseName())){
            return new Model(500, " 房屋名称为空");
        }

        if(ParaClick.clickString(newHouseData.getNewHouseType())){
            return new Model(500, "类型为空");
        }
        if(ParaClick.clickString(newHouseData.getNewHouseYear())){
            return new Model(500, "年限");
        }
        boolean flag= newHouseService.addNewHouse(newHouseData);
        if(!flag){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,"查询成功");
    }

    /***
     * phm
     * 修改新房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.UPDATE_NEWHOUSE,method = RequestMethod.POST)
    public Model updateOldHouse(NewHouseData newHouseData){
        if(ParaClick.clickString( newHouseData.getId())){
            return new Model(500, " id 为空");
        }
        boolean oldHouse= newHouseService.updateNewHouse(newHouseData);
        if(!oldHouse){
            return new Model(500,"修改失敗");
        }
        return new Model(200,"修改成功");
    }
    /***
     * phm
     * 删除新房
     */
    @ResponseBody
    @RequestMapping(value= ActionUrl.DELETE_NEWHOUSE,method = RequestMethod.POST)
    public Model deleteOldHouseByid(NewHouseData newHouseData){
        if(newHouseData.getId()==null){
            return new Model(500,"id为空");
        }
        boolean flag= newHouseService.deleteNewHouseById(newHouseData);
        if(!flag){
            return new Model(500,"删除失敗");
        }
        return new Model(200,"删除成功");
    }
    /**
     * phm
     * 前端用户查看新房
     * */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_PC_NEWHOUSE,method = RequestMethod.POST)
    public Model getALLNewHouseByKeHu(HttpSession session, NewHouseData newHouseData){
//        KeHu keHu=(KeHu) session.getAttribute("kehuInfo");
//        if(keHu==null){
//            return new Model(500,"查詢失敗");
//        }
        Model model=new Model();
        List<NewHouse> list= newHouseService.getALLPCNewHouse();
        if(!ParaClick.clickList(list)){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,list);
    }
    /**
     * phm
     * 前端用户查看热门新房
     * */
    @ResponseBody
    @RequestMapping(value= ActionUrl.GET_PC_HOT_NEWHOUSE,method = RequestMethod.POST)
    public Model getALLHOTNewHouse(HttpSession session, NewHouseData newHouseData){
//        KeHu keHu=(KeHu) session.getAttribute("kehuInfo");
//        if(keHu==null){
//            return new Model(500,"查詢失敗");
//        }
        Model model=new Model();
        List<NewHouse> list= newHouseService.getALLPChotNewHouse();
        if(!ParaClick.clickList(list)){
            return new Model(500,"查詢失敗");
        }
        return new Model(200,list);
    }
}
