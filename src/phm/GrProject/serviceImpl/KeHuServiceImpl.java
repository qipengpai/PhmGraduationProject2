package phm.GrProject.serviceImpl;

import org.springframework.stereotype.Service;
import phm.GrProject.base.BaseServiceImpl;
import phm.GrProject.entity.Administrators;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entity.NewHouse;
import phm.GrProject.entityvo.KeHuData;
import phm.GrProject.service.KeHuService;
import phm.GrProject.tool.MD5;
import phm.GrProject.tool.ParaClick;

import java.util.Date;
import java.util.List;

@Service
public class KeHuServiceImpl extends BaseServiceImpl<KeHu> implements KeHuService{

    @Override
    public boolean saveKeHu(KeHuData keHuData) {
        boolean flag=false;
        try{
            KeHu keHu=new KeHu();
            keHu.setAdminName(keHuData.getAdminName());
            keHu.setAdminPwd(MD5.getMd5(keHuData.getAdminPwd()));
            keHu.setRegisteredDate(new Date());
            super.save(keHu);
            flag=true;
        }catch(Exception E){
            E.printStackTrace();
            return flag;
        }
        return flag;
    }

    @Override
    public List<KeHu> kehulogin(String username, String adminPwd) {
            List<KeHu> list=SQL("SELECT * from Kehu WHERE (adminName='"+username+"' or phone='"+username+"') and adminPwd='"+MD5.getMd5(adminPwd)+"'", KeHu.class);
        return list;
    }

    @Override
    public List<KeHu> getAllKeHu(KeHuData keHuData) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select  *  from  keHu  WHERE 1=1 ");
        if(!ParaClick.clickString(keHuData.getContident())){
            sb.append("  AND ((name like '%"+keHuData.getContident()+"%') or (phone like '%"+keHuData.getContident()+"%') or (hobby like '%"+keHuData.getContident()+"%'))");
        }
        sb.append("   ORDER BY  implDate  DESC limit "+(Integer.parseInt(keHuData.getNowPage())-1)*10+",10");
        List<KeHu> KeHu=super.SQL(sb.toString(), KeHu.class);
        return KeHu;
    }

    @Override
    public int getTotalsize(KeHuData keHuData) {
        StringBuffer sb=new StringBuffer();
        sb.append( " select  count(*)  from  keHu  WHERE 1=1 ");
        if(!ParaClick.clickString(keHuData.getContident())){
            sb.append("  AND ((name like '%"+keHuData.getContident()+"%') or (phone like '%"+keHuData.getContident()+"%') or (hobby like '%"+keHuData.getContident()+"%'))");
        }
        int num=super.gettotalpage(sb.toString());
        return num;
    }

    @Override
    public KeHu getKeHuById(KeHuData keHuData) {
        KeHu KeHu=super.get(keHuData.getId());
        return KeHu;
    }

    @Override
    public boolean updateKuHuInfo(KeHuData keHuData) {
        boolean flag=false;
        try{
            KeHu keHu=super.get(keHuData.getId());
            if(keHu!=null){
                if(ParaClick.clickString(keHuData.getAge())){
                    keHu.setAge(keHuData.getAge());
                }
                if(ParaClick.clickString(keHuData.getDmoney())){
                    keHu.setDmoney(Double.parseDouble(keHuData.getDmoney()));
                }
                if(ParaClick.clickString(keHuData.getGmoney())){
                    keHu.setGmoney(Double.parseDouble(keHuData.getGmoney()));
                }
                if(ParaClick.clickString(keHuData.getHobby())){
                    keHu.setHobby(keHuData.getHobby());
                }
                if(ParaClick.clickString(keHuData.getName())){
                    keHu.setName(keHuData.getName());
                }
                if(ParaClick.clickString(keHuData.getPhone())){
                    keHu.setPhone(keHuData.getPhone());
                }
                if(ParaClick.clickString(keHuData.getRemarks())){
                    keHu.setRemarks(keHuData.getRemarks());
                }
                if(ParaClick.clickString(keHuData.getSex())){
                    keHu.setSex(Integer.parseInt(keHuData.getSex()));
                }
                if(ParaClick.clickString(keHuData.getTarget())){
                    keHu.setTarget(keHuData.getTarget());
                }
                keHu.setImplDate(new Date());
                flag=true;
            }else{
                return flag;
            }
        }catch (Exception e){
            e.printStackTrace();
            return flag;
        }
        return flag;

    }
}
