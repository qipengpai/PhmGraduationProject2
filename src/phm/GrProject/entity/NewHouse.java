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
public class NewHouse extends BaseEntity implements Serializable {

    @SuppressWarnings("static-access")
    @Id
    private String id=ran.generateString(32);
    private String newHouseName;//房屋名称（二期七号楼三单元302）
    private String newHouseAddress;//所在楼盘（长青园小区）
    private Double newHouseMoney;//价格
    private String area;//面积
    private String newHouseType;//户型（两室一厅）
    private String newHouseFloor;//楼层
    private String newHouseYear;//建筑年代（2006）
    private Integer state;//销售状态
    private String newHouseImg;//图片详情
    private Date implDate;//操作时间
    private Integer hot;//热度
    private Integer sort;//顺序
    private String HouseJie;//介绍

    public String getHouseJie() {
        return HouseJie;
    }

    public void setHouseJie(String houseJie) {
        HouseJie = houseJie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewHouseName() {
        return newHouseName;
    }

    public void setNewHouseName(String newHouseName) {
        this.newHouseName = newHouseName;
    }

    public String getNewHouseAddress() {
        return newHouseAddress;
    }

    public void setNewHouseAddress(String newHouseAddress) {
        this.newHouseAddress = newHouseAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNewHouseType() {
        return newHouseType;
    }

    public void setNewHouseType(String newHouseType) {
        this.newHouseType = newHouseType;
    }

    public String getNewHouseFloor() {
        return newHouseFloor;
    }

    public void setNewHouseFloor(String newHouseFloor) {
        this.newHouseFloor = newHouseFloor;
    }

    public String getNewHouseYear() {
        return newHouseYear;
    }

    public void setNewHouseYear(String newHouseYear) {
        this.newHouseYear = newHouseYear;
    }
    public String getNewHouseImg() {
        return newHouseImg;
    }

    public void setNewHouseImg(String newHouseImg) {
        this.newHouseImg = newHouseImg;
    }

    public Double getNewHouseMoney() {
        return newHouseMoney;
    }

    public void setNewHouseMoney(Double newHouseMoney) {
        this.newHouseMoney = newHouseMoney;
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
}
