package phm.GrProject.entityvo;

import java.util.Date;

public class NewHouseData {

    private String id;
    private String newHouseName;//房屋名称（二期七号楼三单元302）
    private String newHouseAddress;//所在楼盘（长青园小区）
    private String newHouseMoney;//价格
    private String area;//面积
    private String newHouseType;//户型（两室一厅）
    private String newHouseFloor;//楼层
    private String newHouseYear;//建筑年代（2006）
    private String state;//销售状态
    private String newHouseImg;//图片详情
    private String implDate;//操作时间
    private String hot;//热度
    private String sort;//顺序
    private String nowPage;
    private String contident;
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

    public String getNewHouseMoney() {
        return newHouseMoney;
    }

    public void setNewHouseMoney(String newHouseMoney) {
        this.newHouseMoney = newHouseMoney;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNewHouseImg() {
        return newHouseImg;
    }

    public void setNewHouseImg(String newHouseImg) {
        this.newHouseImg = newHouseImg;
    }

    public String getImplDate() {
        return implDate;
    }

    public void setImplDate(String implDate) {
        this.implDate = implDate;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public String getContident() {
        return contident;
    }

    public void setContident(String contident) {
        this.contident = contident;
    }
}
