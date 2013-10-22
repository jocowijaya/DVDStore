package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "delivery_table")
/*
@NamedQueries({
        @NamedQuery(name = "findAllCus", query = "select c from Customer c"),
        @NamedQuery(name = "findCusWithFirstName", query = "select c from Customer c where c.firstName = ?1"),
        @NamedQuery(name = "findCusWithLastName", query = "select c from Customer c where c.lastName = ?1")
})
*/
public class Delivery
{
	// ======================================
	// =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
	private Long DID;
	@Column(nullable = false)
	private String deliveryNumber;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	@Column(nullable = false)
	private String deliveryStatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "deliveryDetail_fk")
	private List<DeliveryDetail> deliveryDetails;

	// ======================================
	// =            Constructors            =
    // ======================================

    public Delivery()
    {

	}

	public Delivery(String deliveryNumber, Date deliveryDate, String deliveryStatus)
	{
		this.deliveryNumber = deliveryNumber;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

    public Long getDID()
	{
		return DID;
	}

	public String getDeliveryNumber()
	{
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber)
	{
		this.deliveryNumber = deliveryNumber;
	}

	public Date getDeliveryDate()
	{
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryStatus()
	{
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus)
	{
		this.deliveryStatus = deliveryStatus;
	}

	public List<DeliveryDetail> getDeliveryDetails()
	{
		return deliveryDetails;
	}

	public void setDeliveryDetails(List<DeliveryDetail> deliveryDetails)
	{
		this.deliveryDetails = deliveryDetails;
	}

}