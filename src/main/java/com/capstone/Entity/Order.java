
package com.capstone.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "order_table")

public class Order
{
	// ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long OID;
    @Column(nullable = false)
    private String orderNumber;
    @Column(nullable = false)
    private String orderStatus;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "salesOrderDetail_fk", nullable = true)
    private List<SalesOrderDetail> salesOrderDetails;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "leasesOrderDetail_fk", nullable = true)
    private List<LeasesOrderDetail> leasesOrderDetails;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_fk", nullable = true)
    private List<Delivery> deliveries;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "onlinePayment_fk", nullable = true)
    private List<OnlinePayment> onlinePayments;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cash_fk", nullable = true)
    private List<Cash> cashes;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Order()
    {
    }

    public Order(String orderNumber, String orderStatus)
    {
    	this.orderNumber = orderNumber;
	this.orderStatus = orderStatus;
	this.orderDate = new Date();
    }

    public Order(String orderNumber, String orderStatus, Date orderDate)
    {
	this.orderNumber = orderNumber;
	this.orderStatus = orderStatus;
	this.orderDate = orderDate;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getOID()
    {
	return OID;
    }

    public String getOrderNumber()
    {
	return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
	this.orderNumber = orderNumber;
    }

    public String getOrderStatus()
    {
	return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
    	this.orderStatus = orderStatus;
    }

    public Date getOrderDate()
    {
	return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
	this.orderDate = orderDate;
    }

    public List<SalesOrderDetail> getSalesOrderDetails()
    {
	return salesOrderDetails;
    }
    
    public void setSalesOrderDetails(List<SalesOrderDetail> salesOrderDetails)
    {
	this.salesOrderDetails = salesOrderDetails;
    }

    public List<LeasesOrderDetail> getLeasesOrderDetails()
    {
	return leasesOrderDetails;
    }

    public void setLeasesOrderDetails(List<LeasesOrderDetail> leasesOrderDetails)
    {
	this.leasesOrderDetails = leasesOrderDetails;
    }

    public List<Delivery> getDeliveries()
    {
	return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries)
    {
	this.deliveries = deliveries;
    }

    public List<OnlinePayment> getOnlinePayments()
    {
	return onlinePayments;
    }

    public void setOnlinePayments(List<OnlinePayment> onlinePayments)
    {
	this.onlinePayments = onlinePayments;
    }

    public List<Cash> getCash()
    {
	return cashes;
    }

    public void setCash(List<Cash> cashes)
    {
	this.cashes = cashes;
    }

}