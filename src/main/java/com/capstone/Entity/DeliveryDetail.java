package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.List;

@Entity
@Table(name = "deliveryDetail_table")

public class DeliveryDetail
{
    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long DDID;
    @Column(nullable = false)
    private Integer nbrItemDelivered;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_fk", nullable = false)
    private Product product;

    // ======================================
    // =            Constructors            =
    // ======================================

    public DeliveryDetail()
    {

    }

    public DeliveryDetail(Integer nbrItemDelivered)
    {
	this.nbrItemDelivered = nbrItemDelivered;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getDDID()
    {
	return DDID;
    }

    public Integer getNbrItemDelivered()
    {
	return nbrItemDelivered;
    }

    public void setNbrItemDelivered(Integer nbrItemDelivered)
    {
	this.nbrItemDelivered = nbrItemDelivered;
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