package phm.GrProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phm.GrProject.base.BaseServiceImpl;
import phm.GrProject.entity.Landlord;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.LandlordData;
import phm.GrProject.service.LandlordService;
import phm.GrProject.service.OldHouseService;
import phm.GrProject.tool.ParaClick;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class LandlordServiceImpl extends BaseServiceImpl<Landlord> implements LandlordService {
    @Autowired
    private OldHouseService oldHouseService;

    @Override
    public Landlord getOldHouseById(LandlordData landlordData) {
        Landlord landlord = super.get(landlordData.getId());
        return landlord;
    }

    @Override
    public List<Landlord> getAllOldHouse(LandlordData landlordData) {
        StringBuffer sb=new StringBuffer();
        sb.append("select * from Landlord where 1=1 ");
        if(!ParaClick.clickString(landlordData.getContident())){
            sb.append(" AND ((name like '%"+landlordData.getContident()+"%') or ( phone like '%"+landlordData.getContident()+"%'))");
        }
        sb.append("  ORDER BY registeredDate DESC limit "+(Integer.parseInt(landlordData.getNowPage())-1)*10+",10");
        List<Landlord> list=SQL(sb.toString(),Landlord.class);
        return list;
    }

    @Override
    public int getTotalsize(LandlordData landlordData) {
        StringBuffer sb=new StringBuffer();
        sb.append("select count(*) from Landlord where 1=1 ");
        if(!ParaClick.clickString(landlordData.getContident())){
            sb.append(" AND ((name like '%"+landlordData.getContident()+"%') or ( phone like '%"+landlordData.getContident()+"%'))");
        }
        int num=super.gettotalpage(sb.toString());
        return num;
    }

    @Override
    public boolean addLandlord(LandlordData landlordData) {
        boolean flag=false;
        try{
            Landlord landlord=new Landlord();
            landlord.setAge(landlordData.getAge());
            landlord.setImplDate(new Date());
            landlord.setName(landlordData.getName());
            landlord.setPhone(landlordData.getPhone());
            landlord.setRegisteredDate(new Date());
            landlord.setIdCard(landlordData.getIdCard());
            landlord.setSex(Integer.parseInt(landlordData.getSex()));
            super.save(landlord);
            flag=true;
        }catch(Exception E){
            E.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public boolean updateLandlord(LandlordData landlordData) {
        boolean flag=false;
        try{
            Landlord landlord=super.get(landlordData.getId());
            if(landlord!=null){
                if(!ParaClick.clickString(landlordData.getSex())){
                    landlord.setSex(Integer.parseInt(landlordData.getSex()));
                }
                if(!ParaClick.clickString(landlordData.getAge())){
                    landlord.setAge(landlordData.getAge());
                }
                if(!ParaClick.clickString(landlordData.getName())){
                    landlord.setName(landlordData.getName());
                }
                if(!ParaClick.clickString(landlordData.getPhone())){
                    landlord.setPhone(landlordData.getPhone());
                }
                if(!ParaClick.clickString(landlordData.getIdCard())){
                    landlord.setIdCard(landlordData.getIdCard());
                }
                landlord.setImplDate(new Date());
                flag=true;
            }else {
                return flag;
            }
        }catch(Exception E){
            E.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public boolean deletelandlord(LandlordData landlordData) {
        boolean flag=false;
        try{
            Landlord landlord=super.get(landlordData.getId());
            if(landlord!=null){
                super.delete(landlord);
                boolean flag2= oldHouseService.deleteOldHouseByLandlord(landlordData.getId());
                if(!flag2){
                    return flag;
                }
                flag=true;
            }else{
                return flag;
            }
        }catch(Exception E){
            E.printStackTrace();
            return flag;
        }
        return flag;
    }
}
