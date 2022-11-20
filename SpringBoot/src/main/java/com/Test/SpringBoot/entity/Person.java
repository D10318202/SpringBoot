package com.Test.SpringBoot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Entity
@Table(name = "person")
@NamedQuery(name = "Person.findall", query = "SELECT p FROM Person p")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID", unique = true)
	private String id;
	
	//Serial No Setting
	@Column(name = "serial_no", unique=true)
	private Long serialNo;
	
	@Column(name = "last_name", length=20)
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "person") //表示级练操作
	@OrderBy(value = "serial_no ASC")
	private List<Car> carlist;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Car> getCarlist() {
		return carlist;
	}

	public void setCarlist(List<Car> carlist) {
		this.carlist = carlist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
