
package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "leasesOrderDetail_table")

public class LeasesOrderDetail extends OrderDetail
{
    // ======================================
    // =             Attributes             =
    // ======================================
    @Column(nullable = false)
    private Double leaseItemPrice;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date leasedDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnedDate;
    @Column(nullable = false)
    private Integer leaseQuantity;
    @Column(nullable = false)
    private Integer leaseItemDP;
    @Column(nullable = false)
    private Integer leaseNbrItemDelivered;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_fk")
    private Product product;

    // ======================================
    // =            Constructors            =
    // ======================================

    public LeasesOrderDetail()
    {

    }

    public LeasesOrderDetail(Double leaseItemPrice, Date leasedDate, Date dueDate, Date returnedDate, Integer leaseQuantity, Integer leaseItemDP, Integer leaseNbrItemDelivered)
    {
	super();
	this.leaseItemPrice = leaseItemPrice;
	this.leasedDate = leasedDate;
	this.dueDate = dueDate;
	this.returnedDate = returnedDate;
	this.leaseQuantity = leaseQuantity;
	this.leaseItemDP = leaseItemDP;
	this.leaseNbrItemDelivered = leaseNbrItemDelivered;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Double getLeaseItemPrice()
    {
	return leaseItemPrice;
    }

    public void setLeaseItemPrice(Double leaseItemPrice)
    {
	this.leaseItemPrice = leaseItemPrice;
    }

    public Date getLeaseDate()
    {
	return leasedDate;
    }

    public void setLeaseDate(Date leasedDate)
    {
	this.leasedDate = leasedDate;
    }

    public Date getDueDate()
    {
	return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
	this.dueDate = dueDate;
    }

    public Date getReturnedDate()
    {
	return returnedDate;
    }

    public void setReturnedDate(Date returnedDate)
    {
	this.returnedDate = returnedDate;
    }

    public Integer getLeaseQuantity()
    {
	return leaseQuantity;
    }

    public void setLeaseQuantity(Integer leaseQuantity)
    {
	this.leaseQuantity = leaseQuantity;
    }

    public Integer getLeaseItemDP()
    {
	return leaseItemDP;
    }

    public void setLeaseItemDP(Integer leaseItemDP)
    {
	this.leaseItemDP = leaseItemDP;
    }

    public Integer getLeaseNbrItemDelivered()
    {
	return leaseNbrItemDelivered;
    }

    public void setLeaseNbrItemDelivered(Integer leaseNbrItemDelivered)
    {
	this.leaseNbrItemDelivered = leaseNbrItemDelivered;
    }
    
    public Product getProduct()
    {
	return product;
    }

    public void setProduct(Product product)
    {
	this.product = product;
    }
}