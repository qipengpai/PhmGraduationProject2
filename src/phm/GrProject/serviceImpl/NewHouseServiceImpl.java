package phm.GrProject.serviceImpl;

import org.springframework.stereotype.Service;
import phm.GrProject.base.BaseServiceImpl;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entity.NewHouse;
import phm.GrProject.entityvo.NewHouseData;
import phm.GrProject.service.NewHouseService;
import phm.GrProject.tool.ParaClick;

import java.util.Date;
import java.util.List;

@Service
public class NewHouseServiceImpl extends BaseServiceImpl<NewHouse> implements NewHouseService {
    @Override
    public List<NewHouse> getAllOldHouse(NewHouseData newHouseData) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select  *  from  NewHouse  WHERE 1=1 ");
        if(!ParaClick.clickString(newHouseData.getContident())){
            sb.append("  AND ((newHouseName like '%"+newHouseData.getContident()+"%') or (newHouseAddress like '%"+newHouseData.getContident()+"%') or (newHouseType like '%"+newHouseData.getContident()+"%') or (newHouseYear like '%"+newHouseData.getContident()+"%'))");
        }
        sb.append(" ORDER BY state desc,hot DESC limit "+(Integer.parseInt(newHouseData.getNowPage())-1)*10+",10");
        List<NewHouse> NewHouse=super.SQL(sb.toString(), NewHouse.class);
        return NewHouse;
    }

    @Override
    public int getTotalsize(NewHouseData newHouseData) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select  COUNT(*)  from  NewHouse  WHERE 1=1 ");
        if(!ParaClick.clickString(newHouseData.getContident())){
            sb.append("  AND ((newHouseName like '%"+newHouseData.getContident()+"%') or (newHouseAddress like '%"+newHouseData.getContident()+"%') or (newHouseType like '%"+newHouseData.getContident()+"%') or (newHouseYear like '%"+newHouseData.getContident()+"%'))");
        }
        int num =super.gettotalpage(sb.toString());
        return num;
    }

    @Override
    public NewHouse getNewHouseById(NewHouseData newHouseData) {
        NewHouse newHouse= super.get(newHouseData.getId());
        return newHouse;
    }

    @Override
    public boolean addNewHouse(NewHouseData newHouseData) {
        boolean flag=false;
        try{
            NewHouse newHouse=new NewHouse();
            newHouse.setArea(newHouseData.getArea());
            newHouse.setHot(0);
            newHouse.setImplDate(new Date());
            newHouse.setNewHouseImg(newHouseData.getNewHouseImg());
            newHouse.setNewHouseAddress(newHouseData.getNewHouseAddress());
            newHouse.setNewHouseFloor(newHouseData.getNewHouseFloor());
            newHouse.setHouseJie(newHouseData.getHouseJie());
            newHouse.setNewHouseMoney(Double.parseDouble(newHouseData.getNewHouseMoney()));
            newHouse.setNewHouseName(newHouseData.getNewHouseName());
            newHouse.setNewHouseType(newHouseData.getNewHouseType());
            newHouse.setNewHouseYear(newHouseData.getNewHouseYear());
            newHouse.setSort(0);
            newHouse.setState(1);
            super.save(newHouse);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;

    }

    @Override
    public boolean updateNewHouse(NewHouseData newHouseData) {
        boolean flag=false;
        try{
            NewHouse newHouse=super.get(newHouseData.getId());
            if(newHouse!=null){
                if(!ParaClick.clickString(newHouseData.getArea())){
                    newHouse.setArea(newHouseData.getArea());
                }
                if(!ParaClick.clickString( newHouseData.getNewHouseImg())){
                    newHouse.setNewHouseImg(newHouseData.getNewHouseImg());
                }
                if(!ParaClick.clickString( newHouseData.getNewHouseAddress())){
                    newHouse.setNewHouseAddress(newHouseData.getNewHouseAddress());
                }
                if(!ParaClick.clickString( newHouseData.getNewHouseFloor())){
                    newHouse.setNewHouseFloor(newHouseData.getNewHouseFloor());
                }
                if(!ParaClick.clickString(newHouseData.getNewHouseMoney())){
                    newHouse.setNewHouseMoney(Double.parseDouble(newHouseData.getNewHouseMoney()));
                }
                if(!ParaClick.clickString(newHouseData.getNewHouseName())){
                    newHouse.setNewHouseName(newHouseData.getNewHouseName());
                }
                if(!ParaClick.clickString( newHouseData.getNewHouseType())){
                    newHouse.setNewHouseType(newHouseData.getNewHouseType());
                }
                if(!ParaClick.clickString(newHouseData.getHouseJie())){
                    newHouse.setHouseJie(newHouseData.getHouseJie());
                }
                if(!ParaClick.clickString(newHouseData.getNewHouseYear())){
                    newHouse.setNewHouseYear(newHouseData.getNewHouseYear());
                }
                if(!ParaClick.clickString( newHouseData.getHot())){
                    newHouse.setHot(Integer.parseInt(newHouseData.getHot()));
                }
                if(!ParaClick.clickString( newHouseData.getState())){
                    newHouse.setState(Integer.parseInt(newHouseData.getState()));
                }
                newHouse.setImplDate(new Date());
                flag=true;
            }else{
                return flag;
            }
        }catch(Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public boolean deleteNewHouseById(NewHouseData newHouseData) {
        boolean flag=false;
        try {
            NewHouse newHouse = super.get(newHouseData.getId());
            if (newHouse == null) {
                return flag;
            }
            super.delete(newHouseData.getId());
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public List<NewHouse> getALLNewHouseByKeHu(NewHouseData newHouseData,KeHu kefu) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select  COUNT(*)  from  NewHouse n,OldHouse o WHERE 1=1 ");
        if(!ParaClick.clickString(kefu.getHobby())){
            sb.append("  AND ((n.newHouseType like '%"+kefu.getHobby()+"%') or (n.oldHouseType like '%"+kefu.getHobby()+"%'))");
        }
        List<NewHouse> NewHouse=super.SQL(sb.toString(), NewHouse.class);
        return NewHouse;
    }

    @Override
    public List<NewHouse> getALLPCNewHouse() {
        List<NewHouse> NewHouse=super.SQL("select  *  from  NewHouse where  state=1", NewHouse.class);
        return NewHouse;
    }

    @Override
    public List<NewHouse> getALLPChotNewHouse() {
        List<NewHouse> NewHouse=super.SQL("select  *  from  NewHouse where   state=1 and hot=1", NewHouse.class);
        return NewHouse;
    }
}
