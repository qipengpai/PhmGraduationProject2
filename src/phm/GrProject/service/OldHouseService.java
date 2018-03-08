package phm.GrProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phm.GrProject.base.BaseService;
import phm.GrProject.entity.OldHouse;
import phm.GrProject.entityvo.OldHouseData;

import java.util.List;

@Service
@Transactional
public interface OldHouseService extends BaseService<OldHouse> {

    List<OldHouse> getAllOldHouse(OldHouseData oldHouseData);

    int getTotalsize(OldHouseData oldHouseData);

    OldHouse getOldHouseById(OldHouseData oldHouseData);

    boolean addOldHouse(OldHouseData oldHouseData);

    boolean deleteOldHouseById(OldHouseData oldHouseData);

    boolean updateOldHouse(OldHouseData oldHouseData);

    List<OldHouse> getAllOldHouseByLandlord(String landlordId);

    boolean deleteOldHouseByLandlord(String id);

    List<OldHouse> getAllPCOldHouse();

    List<OldHouse> getAllPCHotOldHouse();
}
