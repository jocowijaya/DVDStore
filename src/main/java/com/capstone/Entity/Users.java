package com.capstone.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
@Inheritance(strategy = InheritanceType.JOINED)

public class Users
{
    @Id
    @GeneratedValue
    protected Long USID;
    @Column(nullable = false, unique = true)
    protected String email;
    @Column(nullable = false)
    protected String password;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Users()
	{

	}

	public Users(String email, String password)
	{
		this.email = email;
		this.password = password;

	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

	public Long getUSID()
	{
		return USID;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}