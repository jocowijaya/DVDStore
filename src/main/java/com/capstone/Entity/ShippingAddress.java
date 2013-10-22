
package com.capstone.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "shippingAddress_table")

public class ShippingAddress extends Address implements Serializable
{
	// ======================================
	// =            Constructors            =
    // ======================================

    public ShippingAddress()
    {

	}

	public ShippingAddress(String street, String suburb, String addressState, String postcode)
	{
		super(street,addressState,suburb,postcode);
	}
}