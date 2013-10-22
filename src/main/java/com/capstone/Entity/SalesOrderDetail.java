

package com.capstone.Entity;

import javax.persistence.*;

@Entity
@Table(name = "salesOrderDetail_table")

public class SalesOrderDetail extends OrderDetail
{
    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(nullable = false)
    private Double salesItemPrice;
    @Column(nullable = false)
    private Integer salesQuantity;
    @Column(nullable = false)
    private Integer salesItemDP;
    @Column(nullable = false)
    private Integer salesNbrItemDelivered;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_fk")
    private Product product;

    // ======================================
    // =            Constructors            =
    // ======================================

    public SalesOrderDetail()
    {

    }

    public SalesOrderDetail(Double salesItemPrice, Integer salesQuantity, Integer salesItemDP, Integer salesNbrItemDelivered)
    {
	super();
	this.salesItemPrice = salesItemPrice;
	this.salesQuantity = salesQuantity;
	this.salesItemDP = salesItemDP;
	this.salesNbrItemDelivered = salesNbrItemDelivered;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Double getSalesItemPrice()
    {
	return salesItemPrice;
    }

    public void setSalesItemPrice(Double salesItemPrice)
    {
	this.salesItemPrice=salesItemPrice;
    }

    public Integer getSalesQuantity()
    {
    	return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity)
    {
	this.salesQuantity = salesQuantity;
    }

    public Integer getSalesItemDP()
    {
	return salesItemDP;
    }

    public void setSalesItemDP(Integer salesItemDP)
    {
	this.salesItemDP = salesItemDP;
    }

    public Integer getSalesNbrItemDelivered()
    {
	return salesNbrItemDelivered;
    }

    public void setSalesNbrItemDelivered(Integer salesNbrItemDelivered)
    {
	this.salesNbrItemDelivered = salesNbrItemDelivered;
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