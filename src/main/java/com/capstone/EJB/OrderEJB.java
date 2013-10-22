package com.capstone.EJB;

import com.capstone.Entity.Order;
import com.capstone.Entity.LeasesOrderDetail;
import com.capstone.Entity.SalesOrderDetail;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public boolean createOrder(Order order) {
        boolean check = true;
	try
	{
            em.persist(order);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean createSalesOrder(SalesOrderDetail order) {
        boolean check = true;
	try
	{
            em.persist(order);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean createLeasesOrder(LeasesOrderDetail order) {
        boolean check = true;
	try
	{
            em.persist(order);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

}