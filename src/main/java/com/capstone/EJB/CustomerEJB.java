package com.capstone.EJB;

import com.capstone.Entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Customer> findCustomers(String strQuery)
    {
	TypedQuery<Customer> query = em.createQuery(strQuery, Customer.class);
	List<Customer> ls = query.getResultList();
	return ls;
    }
    
    public Customer findCustomerWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Customer.class);
	Customer ls = (Customer) query.getSingleResult();
	return ls;
    }
    
    public BillingAddress findBillingAddress(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, BillingAddress.class);
	BillingAddress ls = (BillingAddress) query.getSingleResult();
	return ls;
    }
    
    public ShippingAddress findShippingAddress(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, ShippingAddress.class);
	ShippingAddress ls = (ShippingAddress) query.getSingleResult();
	return ls;
    }

    public boolean createCustomer(Customer customer) {
	boolean check = true;
	try
	{
            em.persist(customer);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createBillingAddress(BillingAddress billingAddress) {
	boolean check = true;
	try
	{
            em.persist(billingAddress);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createShippingAddress(ShippingAddress shippingAddress) {
	boolean check = true;
	try
	{
            em.persist(shippingAddress);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean deleteCustomer(Customer customer) {
	boolean check = true;
	try
	{
            em.remove(em.merge(customer));
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean updateCustomer(Customer customer) {
	boolean check = true;
	try
	{
            em.merge(customer);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean updateBillingAddress(BillingAddress billingAddress) {
	boolean check = true;
	try
	{
            em.merge(billingAddress);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean updateShippingAddress(ShippingAddress shippingAddress) {
	boolean check = true;
	try
	{
            em.merge(shippingAddress);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
}