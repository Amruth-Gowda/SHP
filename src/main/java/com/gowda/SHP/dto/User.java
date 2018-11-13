package com.gowda.SHP.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	private String username;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "doorNo", column = @Column(name = "office_door_no")),
			@AttributeOverride(name = "street", column = @Column(name = "office_steet")),
			@AttributeOverride(name = "city", column = @Column(name = "office_city")),
			@AttributeOverride(name = "state", column = @Column(name = "office_state")) })
	private Address officeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "doorNo", column = @Column(name = "home_door_no")),
			@AttributeOverride(name = "street", column = @Column(name = "home_steet")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state")) })
	private Address homeAddress;

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
