
package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "address_table")
@Inheritance(strategy = InheritanceType.JOINED)

public class Address
{
	// ======================================
	// =             Attributes             =
    // ======================================

	@Id
	@GeneratedValue
	protected Long AID;
	@Column(nullable = false)
	protected String street;
	@Column(nullable = false)
	protected String suburb;
	@Column(nullable = false)
	protected String addressState;
	@Column(nullable = false)
	protected String postcode;

	// ======================================
	// =            Constructors            =
    // ======================================

    public Address()
    {

    }

	public Address(String street, String suburb, String addressState, String postcode)
	{
		this.street = street;
		this.suburb = suburb;
		this.addressState = addressState;
		this.postcode = postcode;
	}

	// ======================================
	// =          Getters & Setters         =
        // ======================================

	public Long AID()
	{
		return AID;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getSuburb()
	{
		return suburb;
	}

	public void setSuburb(String suburb)
	{
		this.suburb = suburb;
	}

	public String getAddressState()
	{
		return addressState;
	}

	public void setAddressState(String addressState)
	{
		this.addressState = addressState;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}
}