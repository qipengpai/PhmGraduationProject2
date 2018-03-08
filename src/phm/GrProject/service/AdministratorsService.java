package phm.GrProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phm.GrProject.base.BaseService;
import phm.GrProject.entity.Administrators;

import java.util.List;


@Service
@Transactional
public interface AdministratorsService extends BaseService<Administrators>{
	
	
	List<Administrators>   login(String username, String userpwd);

	List<Administrators> getAdmin(String code);

    boolean updatePwd(String username, String userpwd, String newpwd);
}
