package phm.GrProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phm.GrProject.base.BaseService;
import phm.GrProject.entity.KeHu;
import phm.GrProject.entity.Landlord;
import phm.GrProject.entity.NewHouse;
import phm.GrProject.entityvo.NewHouseData;

import java.util.List;

@Service
@Transactional
public interface NewHouseService  extends BaseService<NewHouse> {


    List<NewHouse> getAllOldHouse(NewHouseData newHouseData);

    int getTotalsize(NewHouseData newHouseData);

    NewHouse getNewHouseById(NewHouseData newHouseData);

    boolean addNewHouse(NewHouseData newHouseData);

    boolean updateNewHouse(NewHouseData newHouseData);

    boolean deleteNewHouseById(NewHouseData newHouseData);

    List<NewHouse> getALLNewHouseByKeHu(NewHouseData newHouseData,KeHu kefu);

    List<NewHouse> getALLPCNewHouse();

    List<NewHouse> getALLPChotNewHouse();
}
