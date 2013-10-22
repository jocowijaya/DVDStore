package com.capstone.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_table")

public class Customer extends Users implements Serializable
{
	// ======================================
	// =             Attributes             =
    // ======================================

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(nullable = false)
    private String phoneNbr;

    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.REMOVE)
    @JoinColumn(name = "billingAddress_fk", nullable = false)
    private BillingAddress billingAddress;
    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.REMOVE)
    @JoinColumn(name = "shippingAddress_fk", nullable = false)
    private ShippingAddress shippingAddress;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.REMOVE)
    @JoinColumn(name = "order_fk")
    private List<Order> orders;

	// ======================================
	// =            Constructors            =
    // ======================================

    public Customer()
    {

    }

    public Customer(String email, String password, String firstName, String lastName, String phoneNbr)
    {
	super(email, password);
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = new Date();
	this.phoneNbr = phoneNbr;
    }

    public Customer(String email, String password, String firstName, String lastName, Date dateOfBirth, String phoneNbr)
    {
    	super(email, password);
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.phoneNbr = phoneNbr;
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

    public Date getDateOfBirth()
    {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
	this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNbr()
    {
	return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr)
    {
	this.phoneNbr = phoneNbr;
    }

    public BillingAddress getBillingAddress()
    {
	return billingAddress;
    }
    public void setBillingAddress(BillingAddress billingAddress)
    {
    	this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress()
    {
	return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress)
    {
	this.shippingAddress = shippingAddress;
    }

    public List<Order> getOrders()
    {
	return orders;
    }

    public void setOrders(List<Order> orders)
    {
	this.orders = orders;
    }

}