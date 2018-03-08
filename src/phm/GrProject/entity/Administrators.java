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
public class Administrators extends BaseEntity implements Serializable{
	@SuppressWarnings("static-access")
    @Id
	private String id=ran.generateString(32);
	private String adminName="";
	private String adminPwd="";
	private String name="";
	private String phone="";



	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String adminImg="";
	private Date implDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminImg() {
		return adminImg;
	}
	public void setAdminImg(String adminImg) {
		this.adminImg = adminImg;
	}
	public Date getImplDate() {
		return implDate;
	}
	public void setImplDate(Date implDate) {
		this.implDate = implDate;
	}
	
	
}
