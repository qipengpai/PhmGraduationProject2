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
public class KeHu extends BaseEntity implements Serializable{
    @SuppressWarnings("static-access")
    @Id
    private String id=ran.generateString(32);
    private String name;
    private Integer sex;
    private String age;
    private String phone;
    private String hobby;
    private double gmoney;
    private double dmoney;
    private String target;
    private Date registeredDate;
    private Date implDate;
    private String remarks;
    private String adminName;
    private String adminPwd;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public double getGmoney() {
        return gmoney;
    }

    public void setGmoney(double gmoney) {
        this.gmoney = gmoney;
    }

    public double getDmoney() {
        return dmoney;
    }

    public void setDmoney(double dmoney) {
        this.dmoney = dmoney;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
