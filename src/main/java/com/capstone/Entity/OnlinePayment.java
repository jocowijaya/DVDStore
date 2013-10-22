

package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.Date;

@Entity
@Table(name = "onlinePayment_table")

public class OnlinePayment extends Payment
{
	// ======================================
	// =             Attributes             =
    // ======================================

	@Column(nullable = false)
	private String cardNbr;
	@Column(nullable = false)
	private String paymentType;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiredDate;

	// ======================================
	// =            Constructors            =
    // ======================================

    public OnlinePayment()
    {

	}

	public OnlinePayment(Double amount, Date paymentDate, String cardNbr, String paymentType, Date expiredDate)
	{
		super(amount,paymentDate);
		this.cardNbr = cardNbr;
		this.paymentType = paymentType;
		this.expiredDate = expiredDate;
	}

	// ======================================
	// =          Getters & Setters         =
    // ======================================

	public String getCardNbr()
	{
		return cardNbr;
	}

	public void setCardNbr(String cardNbr)
	{
		this.cardNbr = cardNbr;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public Date getExpiredDate()
	{
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate)
	{
		this.expiredDate = expiredDate;
	}

}