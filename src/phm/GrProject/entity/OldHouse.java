package phm.GrProject.entity;

import phm.GrProject.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table
public class OldHouse extends BaseEntity implements Serializable {

    @SuppressWarnings("static-access")
    @Id
    private String id = ran.generateString(32);
    private String oldHouseName;//房屋名称（二期七号楼三单元302）
    private String oldHouseAddress;//所在楼盘（长青园小区）
    private String oldHouseMoney;//价格
    private String area;//面积
    private String oldHouseType;//户型（两室一厅）
    private String oldHouseFloor;//楼层

    private String oldHouseYear;//建筑年代（2006）
    private Integer zxstate;//装修状态
    private String oldHouse;//图片详情
    private String landladyId;//房东
    private Date implDate;//操作时间
    private Integer hot;//操作时间
    private Integer sort;//顺序
    private Integer state;//装修状态
    private String oldHouseJie;//介绍
    public String getOldHouseJie() {
        return oldHouseJie;
    }

    public void setOldHouseJie(String oldHouseJie) {
        this.oldHouseJie = oldHouseJie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldHouseName() {
        return oldHouseName;
    }

    public void setOldHouseName(String oldHouseName) {
        this.oldHouseName = oldHouseName;
    }

    public String getOldHouseAddress() {
        return oldHouseAddress;
    }

    public void setOldHouseAddress(String oldHouseAddress) {
        this.oldHouseAddress = oldHouseAddress;
    }

    public String getOldHouseMoney() {
        return oldHouseMoney;
    }

    public void setOldHouseMoney(String oldHouseMoney) {
        this.oldHouseMoney = oldHouseMoney;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOldHouseType() {
        return oldHouseType;
    }

    public void setOldHouseType(String oldHouseType) {
        this.oldHouseType = oldHouseType;
    }

    public String getOldHouseFloor() {
        return oldHouseFloor;
    }

    public void setOldHouseFloor(String oldHouseFloor) {
        this.oldHouseFloor = oldHouseFloor;
    }

    public String getOldHouseYear() {
        return oldHouseYear;
    }

    public void setOldHouseYear(String oldHouseYear) {
        this.oldHouseYear = oldHouseYear;
    }

    public String getOldHouse() {
        return oldHouse;
    }

    public void setOldHouse(String oldHouse) {
        this.oldHouse = oldHouse;
    }

    public String getLandladyId() {
        return landladyId;
    }

    public void setLandladyId(String landladyId) {
        this.landladyId = landladyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getZxstate() {
        return zxstate;
    }

    public void setZxstate(Integer zxstate) {
        this.zxstate = zxstate;
    }
}
