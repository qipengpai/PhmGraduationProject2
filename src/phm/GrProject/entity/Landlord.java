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
public class Landlord  extends BaseEntity implements Serializable {
    @SuppressWarnings("static-access")
    @Id
    private String id=ran.generateString(32);
    private String name;
    private Integer sex;
    private String age;
    private String phone;
    private Date registeredDate;
    private Date implDate;
    private String idCard;


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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
}
