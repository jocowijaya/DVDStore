
package com.capstone.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "billingAddress_table")

public class BillingAddress extends Address implements Serializable
{
	// ======================================
	// =            Constructors            =
    // ======================================

    public BillingAddress()
    {

	}

	public BillingAddress(String street, String suburb, String addressState, String postcode)
	{
		super(street,suburb,addressState,postcode);
	}

}