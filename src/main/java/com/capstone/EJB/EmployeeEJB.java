package com.capstone.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import com.capstone.Entity.*;

@Stateless
public class EmployeeEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    
    public List<Employee> findEmployees(String strQuery)
    {
	TypedQuery<Employee> query = em.createQuery(strQuery, Employee.class);
	List<Employee> ls = query.getResultList();
	return ls;
    }
    
    public Employee findEmployeeWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Employee.class);
	Employee ls = (Employee) query.getSingleResult();
	return ls;
    }

    public boolean createEmployee(Employee employee) 
    {
        boolean check = true;
	try
	{
            em.persist(employee);
	}
	catch(Exception e)
        {
            check = false;
	}
	return check;
    }
    
    public boolean deleteEmployee(Employee employee) {
	boolean check = true;
	try
	{
            em.remove(em.merge(employee));
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean updateEmployee(Employee employee) {
	boolean check = true;
	try
	{
            em.merge(employee);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

}