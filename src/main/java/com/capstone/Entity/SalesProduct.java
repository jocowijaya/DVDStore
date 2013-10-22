
package com.capstone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salesProduct_table")

public class SalesProduct {

    // ======================================
    // =             Attributes             =
    // ======================================

	@Id
    @GeneratedValue
    protected Long SPID;
    @Column(nullable = false)
    private Double salesPrice;
    @Column(nullable = false)
    private Integer salesDP;

    // ======================================
    // =            Constructors            =
    // ======================================

    public SalesProduct()
    {

	}

    public SalesProduct(Double salesPrice, Integer salesDP) {
        this.salesPrice = salesPrice;
        this.salesDP = salesDP;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
	    this.salesPrice = salesPrice;
    }

	public Integer getSalesDP() {
        return salesDP;
    }

    public void setSalesDP(Integer salesDP) {
		this.salesDP = salesDP;
    }

}