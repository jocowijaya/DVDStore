

package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.Date;

@Entity
@Table(name = "payment_table")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Payment
{
	// ======================================
	// =             Attributes             =
    // ======================================

	@Id
	@GeneratedValue
    protected Long PMID;
	@Column(nullable = false)
	protected Double amount;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date paymentDate;

	// ======================================
	// =            Constructors            =
    // ======================================

    public Payment()
    {

	}

	public Payment(Double amount, Date paymentDate)
	{
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

    public Long getPMID()
    {
		return PMID;
	}

	public Double getAmount()
	{
		return amount;
	}

	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

	public Date getPaymentDate()
	{
		return paymentDate;
	}

	public void setPaymentDate()
	{
		this.paymentDate = paymentDate;
	}
}