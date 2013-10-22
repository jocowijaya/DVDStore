

package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.Date;

@Entity
@Table(name = "cash_table")

public class Cash extends Payment
{
	// ======================================
	// =            Constructors            =
    // ======================================

    public Cash()
    {

	}

	public Cash (Double amount, Date paymentDate)
	{
		super(amount, paymentDate);
	}
}