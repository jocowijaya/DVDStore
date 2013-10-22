package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "orderDetail_table")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class OrderDetail
{
	// ======================================
	// =             Attributes             =
    // ======================================

	@Id
        @GeneratedValue
	private Long ODID;

	// ======================================
	// =            Constructors            =
    // ======================================

	public OrderDetail()
	{

	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

	public Long getODID()
	{
		return ODID;
	}
}