package phm.GrProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phm.GrProject.base.BaseService;
import phm.GrProject.entity.Landlord;
import phm.GrProject.entityvo.LandlordData;

import java.util.List;

@Service
@Transactional
public interface LandlordService extends BaseService<Landlord> {


    Landlord getOldHouseById(LandlordData landlordData);

    List<Landlord> getAllOldHouse(LandlordData landlordData);

    int getTotalsize(LandlordData landlordData);

    boolean addLandlord(LandlordData landlordData);

    boolean updateLandlord(LandlordData landlordData);

    boolean deletelandlord(LandlordData landlordData);
}
