package phm.GrProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phm.GrProject.base.BaseService;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entityvo.KeHuData;

import java.util.List;

@Service
@Transactional
public interface KeHuService extends BaseService<KeHu>{


    boolean saveKeHu(KeHuData keHuData);

    List<KeHu> kehulogin(String username, String adminPwd);

    List<KeHu> getAllKeHu(KeHuData keHuData);

    int getTotalsize(KeHuData keHuData);

    KeHu getKeHuById(KeHuData keHuData);

    boolean updateKuHuInfo(KeHuData keHuData);
}
