package com.capstone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")

public class Employee extends Users
{
	// ======================================
	// =             Attributes             =
    // ======================================

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phoneNbr;
	@Column(nullable = false)
	private String status;

	// ======================================
	// =            Constructors            =
    // ======================================

    public Employee()
    {

	}

	public Employee(String email, String password, String firstName, String lastName, String phoneNbr, String status)
	{
		super(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNbr = phoneNbr;
		this.status = status;
	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhoneNbr()
	{
		return phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr)
	{
		this.phoneNbr = phoneNbr;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

}