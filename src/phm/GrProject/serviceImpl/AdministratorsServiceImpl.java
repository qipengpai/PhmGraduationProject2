package phm.GrProject.serviceImpl;

import org.springframework.stereotype.Service;
import phm.GrProject.base.BaseServiceImpl;
import phm.GrProject.entity.Administrators;
import phm.GrProject.service.AdministratorsService;
import phm.GrProject.tool.MD5;
import phm.GrProject.tool.ParaClick;

import java.util.List;

@Service
public class AdministratorsServiceImpl extends BaseServiceImpl<Administrators> implements AdministratorsService {

		
	@Override
	public List<Administrators> login(String adminName, String adminPwd) {
		List<Administrators> list=SQL("SELECT * from Administrators WHERE (adminName='"+adminName+"' or phone='"+adminName+"') and adminPwd='"+MD5.getMd5(adminPwd)+"'", Administrators.class);
		return list;
	}

	@Override
	public List<Administrators> getAdmin(String code) {
		List<Administrators> list=super.SQL("select * from Administrators WHERE id='"+code+"'", Administrators.class);
		return list;		
	}

	@Override
	public boolean updatePwd(String username, String userpwd, String newpwd) {
		boolean flag = false;
		try {
			String sql = "select * from Administrators where adminName='" + username
					+ "' and adminPwd='" + MD5.getMd5(userpwd) + "'";
			List<Administrators> list = super.SQL(sql, Administrators.class);
			if (!ParaClick.clickList(list)) {
				return flag;
			}
			list.get(0).setAdminPwd(MD5.getMd5(newpwd));
			flag = true;
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
