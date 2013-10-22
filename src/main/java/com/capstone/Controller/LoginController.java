/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.Controller;

import com.capstone.EJB.CustomerEJB;
import com.capstone.EJB.EmployeeEJB;
import com.capstone.Entity.Customer;
import com.capstone.Entity.Employee;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author duy
 */
@ManagedBean
@RequestScoped
public class LoginController
{
    @EJB
    private EmployeeEJB employeeEJB;

    @EJB
    private CustomerEJB customerEJB;

    private String username;
    private String password;
    private FacesMessage msg;
    private boolean activate;

    public void login() throws IOException
    {
        String loggedIn = "false";
        
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;
 
        List<Customer> lsCustomers = customerEJB.findCustomers("select c from Customer c");
        boolean checkCustomer = checkCustomerLogin(username, password, lsCustomers);
        if(checkCustomer == true)
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
            loggedIn = "customer";
            activate = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        }
        else
        {
            List<Employee> lsEmployees = employeeEJB.findEmployees("select e from Employee e");
            boolean checkEmployee = checkEmployeeLogin(username, password, lsEmployees);
            if(checkEmployee == true)
            {
                loggedIn = "admin";  
                activate = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
                
            }
            else
            {  
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid username or password");
            }
            
        }
    
       FacesContext.getCurrentInstance().addMessage(null, msg);  
       context.addCallbackParam("loggedIn", loggedIn);
   
    }


    // Check customer's login
    public boolean checkCustomerLogin(String email, String password, List<Customer> lsCustomers)
    {
        boolean check = false;
        for(int i = 0; i < lsCustomers.size(); i++)
        {
            Customer customer = lsCustomers.get(i);
            if(email.equals(customer.getEmail().trim()) && password.equals(customer.getPassword().trim()))
            {
		check = true;
		break;
            }
	}
        return check;
    }

    // Check customer's login
    public boolean checkEmployeeLogin(String email, String password, List<Employee> lsEmployees)
    {
        boolean check = false;
        for(int i = 0; i < lsEmployees.size(); i++)
        {
            Employee employee = lsEmployees.get(i);
            if(email.equals(employee.getEmail().trim()) && password.equals(employee.getPassword().trim()))
            {
		check = true;
                if(employee.getStatus().equals("Admin"))
                {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", employee.getEmail());
                }
		break;
            }
	}
        return check;
    }
    
    public void logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        activate = false;
    }

    public String navigateSignUp()
    {
        return "signUp.xhtml";
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public boolean getActivate()
    {
        return activate;
    }
    
    public void setActivate(boolean activate)
    {
        this.activate = activate;
    }

}
