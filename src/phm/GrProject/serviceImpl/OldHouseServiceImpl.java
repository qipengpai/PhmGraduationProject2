package phm.GrProject.serviceImpl;

import org.springframework.stereotype.Service;
import phm.GrProject.base.BaseServiceImpl;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.OldHouseData;
import phm.GrProject.service.OldHouseService;
import phm.GrProject.tool.Model;
import phm.GrProject.tool.ParaClick;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class OldHouseServiceImpl extends BaseServiceImpl<OldHouse> implements OldHouseService{

    @Override
    public List<OldHouse> getAllOldHouse(OldHouseData oldHouseData) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select u.* from OldHouse u,landlord l WHERE 1=1 and u.landladyId=l.id");
        if(!ParaClick.clickString(oldHouseData.getCondetion())){
            sb.append("  AND ((u.oldHouseName like '%"+oldHouseData.getCondetion()+"%') or (u.oldHouseAddress like '%"+oldHouseData.getCondetion()+"%') or (l.name like '%"+oldHouseData.getCondetion()+"%'))");
        }
        sb.append(" ORDER BY u.state desc,u.hot DESC limit "+(Integer.parseInt(oldHouseData.getNowPage())-1)*10+",10");
        List<OldHouse> OldHouse=super.SQL(sb.toString(), phm.GrProject.entity.OldHouse.class);
        return OldHouse;
    }

    @Override
    public int getTotalsize(OldHouseData oldHouseData) {
        StringBuffer sb=new StringBuffer();
//        sb.append( " select count(*) from OldHouse u,landlord l WHERE 1=1 and u.landladyId=l.id");
//        if(!ParaClick.clickString(oldHouseData.getCondetion())){
//            sb.append("  AND ((u.oldHouseName like '%"+oldHouseData.getCondetion()+"%') or (u.oldHouseAddress like '%"+oldHouseData.getCondetion()+"%') or (l.name like '%"+oldHouseData.getCondetion()+"%') or (u.condetion like '%"+oldHouseData.getCondetion()+"%'))");
//        }
//        sb.append(" and u.state=1 ");StringBuffer sb=new StringBuffer();
        sb.append( " select count(*) from OldHouse u,landlord l WHERE 1=1 and u.landladyId=l.id");
        if(!ParaClick.clickString(oldHouseData.getCondetion())){
            sb.append("  AND ((u.oldHouseName like '%"+oldHouseData.getCondetion()+"%') or (u.oldHouseAddress like '%"+oldHouseData.getCondetion()+"%') or (l.name like '%"+oldHouseData.getCondetion()+"%'))");
        }

        int OldHouse=super.gettotalpage(sb.toString());
        return OldHouse;
    }

    @Override
    public OldHouse getOldHouseById(OldHouseData oldHouseData) {
        OldHouse oldHouse= super.get(oldHouseData.getId());
        return oldHouse;
    }

    @Override
    public boolean addOldHouse(OldHouseData oldHouseData) {
        boolean flag=false;
        try{
            OldHouse oldHouse=new OldHouse();
            oldHouse.setArea(oldHouseData.getArea());
            oldHouse.setHot(0);
            oldHouse.setImplDate(new Date());
            oldHouse.setLandladyId(oldHouseData.getLandladyId());
            oldHouse.setOldHouse(oldHouseData.getOldHouse());
            oldHouse.setOldHouseAddress(oldHouseData.getOldHouseAddress());
            oldHouse.setOldHouseFloor(oldHouseData.getOldHouseFloor());
            oldHouse.setOldHouseMoney(oldHouseData.getOldHouseMoney());
            oldHouse.setOldHouseJie(oldHouseData.getOldHouseJie());
            oldHouse.setOldHouseName(oldHouseData.getOldHouseName());
            oldHouse.setOldHouseType(oldHouseData.getOldHouseType());
            oldHouse.setOldHouseYear(oldHouseData.getOldHouseYear());
            oldHouse.setZxstate(Integer.parseInt(oldHouseData.getZxstate()));
            oldHouse.setSort(0);
            oldHouse.setState(1);
            super.save(oldHouse);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public boolean deleteOldHouseById(OldHouseData oldHouseData) {
        boolean flag=false;
        try {
            OldHouse oldHouse = super.get(oldHouseData.getId());
            if (oldHouse == null) {
                return flag;
            }
            super.delete(oldHouseData.getId());
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public boolean updateOldHouse(OldHouseData oldHouseData) {
        boolean flag=false;
        try{
            OldHouse oldHouse=super.get(oldHouseData.getId());
            if(oldHouse!=null){
                if(ParaClick.clickString(oldHouseData.getArea())){
                    oldHouse.setArea(oldHouseData.getArea());
                }
//                if(ParaClick.clickString( oldHouseData.getLandladyId())){
//                    oldHouse.setLandladyId(oldHouseData.getLandladyId());
//                }
                if(!ParaClick.clickString( oldHouseData.getOldHouse())){
                    oldHouse.setOldHouse(oldHouseData.getOldHouse());
                }
                if(!ParaClick.clickString( oldHouseData.getOldHouseAddress())){
                    oldHouse.setOldHouseAddress(oldHouseData.getOldHouseAddress());
                }
                if(!ParaClick.clickString( oldHouseData.getOldHouseFloor())){
                    oldHouse.setOldHouseFloor(oldHouseData.getOldHouseFloor());
                }
                if(!ParaClick.clickString( oldHouseData.getOldHouseJie())){
                    oldHouse.setOldHouseJie(oldHouseData.getOldHouseJie());
                }
                if(!ParaClick.clickString(oldHouseData.getOldHouseMoney())){
                    oldHouse.setOldHouseMoney(oldHouseData.getOldHouseMoney());
                }
                if(!ParaClick.clickString(oldHouseData.getOldHouseName())){
                    oldHouse.setOldHouseName(oldHouseData.getOldHouseName());
                }
                if(!ParaClick.clickString( oldHouseData.getOldHouseType())){
                    oldHouse.setOldHouseType(oldHouseData.getOldHouseType());
                }
                if(!ParaClick.clickString(oldHouseData.getOldHouseYear())){
                    oldHouse.setOldHouseYear(oldHouseData.getOldHouseYear());
                }
                if(!ParaClick.clickString(oldHouseData.getZxstate())){
                    oldHouse.setZxstate(Integer.parseInt(oldHouseData.getZxstate()));
                }
                if(!ParaClick.clickString(oldHouseData.getState())){
                    oldHouse.setState(Integer.parseInt(oldHouseData.getState()));
                }
                if(!ParaClick.clickString(oldHouseData.getHot())){
                    oldHouse.setHot(Integer.parseInt(oldHouseData.getHot()));
                }
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
    public List<OldHouse> getAllOldHouseByLandlord(String landlordId) {
        List<OldHouse> list =SQL("select * from OldHouse where landlord='"+landlordId+"' ",OldHouse.class);
        return list;
    }

    @Override
    public boolean deleteOldHouseByLandlord(String id) {
        boolean flag=false;
        try {
            List<OldHouse> list = SQL("select * from OldHouse where landlord='" + id + "' ", OldHouse.class);
            if(!ParaClick.clickList(list)){
                return flag;
            }
            for (int i = 0; i < list.size(); i++) {
                super.delete(list.get(i).getId());
            }
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public List<OldHouse> getAllPCOldHouse() {
        List<OldHouse> list = SQL("select * from OldHouse where  state=1  ", OldHouse.class);
        return list;
    }

    @Override
    public List<OldHouse> getAllPCHotOldHouse() {
        List<OldHouse> list = SQL("select * from OldHouse where  state=1 and hot = 1 ", OldHouse.class);
        return list;
    }
}
