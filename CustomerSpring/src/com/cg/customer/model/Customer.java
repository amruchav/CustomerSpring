package com.cg.customer.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customers")
@NamedQueries({@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
	           @NamedQuery(name = "getAllCustomersIds", query = "SELECT custId FROM Customer cust")
})
public class Customer {

	@Id
	@NotNull(message="Please enter ID")
	private int custId;
	@NotBlank(message="Please enter name")
	//@Pattern(regexp = "{A-Za-z0-9}")
	private String custName;
	
	@NotNull(message="Please enter mobile number")
	//@Pattern(regexp="(^$|[0-9]{10})")*/
	@Length(max=10,min=10,message="Please enter valid mobile no")
	/*@Min(value=0, message="Please enter valid mobile no")
	@Max(value=10,message="Please enter valid mobile no")*/
	private String mobile;
	@Email
	@NotEmpty(message="Please enter email")
	private String email;
	@NotNull(message="enter date")
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date birthDate;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", mobile=" + mobile + ", email=" + email + ", birthDate="
				+ birthDate + "]";
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
