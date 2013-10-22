

package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "leasesProduct_table")

public class LeasesProduct {

    // ======================================
    // =             Attributes             =
    // ======================================

	@Id
    @GeneratedValue
    protected Long LPID;
    @Column(nullable = false)
    private Double leasesPrice;
    @Column(nullable = false)
    private Integer leasesDP;
    @Column(nullable = false)
    private Double lateChargePerDay;

    // ======================================
    // =            Constructors            =
    // ======================================

    public LeasesProduct()
    {

	}

    public LeasesProduct(Double leasesPrice, Integer leasesDP, Double lateChargePerDay) {
        this.leasesPrice = leasesPrice;
        this.leasesDP = leasesDP;
        this.lateChargePerDay = lateChargePerDay;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getLPID()
    {
		return LPID;
	}

    public Double getLeasesPrice() {
        return leasesPrice;
    }

    public void setLeasesPrice(Double leasesPrice) {
	    this.leasesPrice = leasesPrice;
    }

	public Integer getLeasesDP() {
        return leasesDP;
    }

    public void setLeasesDP(Integer leasesDP) {
		this.leasesDP = leasesDP;
    }

	public Double getLateChargePerDay() {
        return lateChargePerDay;
    }

    public void setLateChargePerDay(Double lateChargePerDay) {
		this.lateChargePerDay = lateChargePerDay;
    }

}