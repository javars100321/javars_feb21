package com.rs.fer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_annotation")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String firstName;
	
	@Column
	private String middleName;
	@Column
	private String lastName;

	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String mobile;

	private String created;
	private String updated;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Expense.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private Set<Expense> expenses;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	@JoinColumn(name = "addrId", referencedColumnName = "id")
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCreated() {
		return created;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	}
}
