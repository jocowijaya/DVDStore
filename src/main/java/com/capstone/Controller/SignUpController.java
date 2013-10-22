package com.capstone.Controller;

import com.capstone.EJB.*;
import com.capstone.Entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ViewScoped
public class SignUpController
{

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private UsersEJB usersEJB;

    @EJB
    private CustomerEJB customerEJB;

    @EJB
    private EmployeeEJB employeeEJB;

    private Customer customer = new Customer();
    private BillingAddress billingAddress = new BillingAddress();
    private ShippingAddress shippingAddress = new ShippingAddress();

    private Employee employee = new Employee();
    
    private List<Customer> customerList;
    private List<Employee> employeeList;

    private boolean skip;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private String title;
    private boolean validate;
    private Long customerId;
    
    private final static String[] roles;
    static{
        roles = new String[2];
        roles[0] = "Staff";
        roles[1] = "Admin";
    }
    

    @PostConstruct
    public void setData()
    {
        customerList = customerEJB.findCustomers("select c from Customer c");
        employeeList = employeeEJB.findEmployees("select e from Employee e");
    }

    public boolean checkCustomerEmailExisted()
    {
        List<Users> userList = usersEJB.findUsers("select u from Users u");
        boolean check = true;
        for(int i = 0; i < userList.size(); i++)
        {
            Users users = userList.get(i);
            if(customer.getEmail().trim().equals(users.getEmail().trim()))
            {
                check = false;
                break;
            }
        }
        return check;

    }

   public String doCreateCustomer()
   {
        boolean check = checkCustomerEmailExisted();
        if(check == true)
        {
            try
            {
                boolean checkBillingAdd = customerEJB.createBillingAddress(billingAddress);
                boolean checkShippingAdd = customerEJB.createShippingAddress(shippingAddress);

                Customer c1 = new Customer(customer.getEmail(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getDateOfBirth(), customer.getPhoneNbr());
                c1.setBillingAddress(billingAddress);
                c1.setShippingAddress(shippingAddress);
                boolean checkCustomer = customerEJB.createCustomer(c1);
                if(checkBillingAdd == true && checkShippingAdd == true && checkCustomer == true)
                {
                    showMessage("Successful","Congratulation, your account has been created successful");
                }
                else
                {
                    showMessage("Error Message","Data cannot persist");
                }
            }
            catch(Exception e)
            {
                //showMessage("dtails",billingAddress.getStreet()+ billingAddress.getSuburb()+ billingAddress.getAddressState()+billingAddress.getPostcode());
                showMessage("Error Message","Data cannot persist to database");
            }
         }
         else
         {
             showMessage("Duplicated", "This email address has existed, please use another one");
         }
         return "";

    }
   
   public void doAction()
   {
       if(title.equals("Create New Customer"))
       {
           doCreateCustomer();
       }
       if(title.equals("Edit Customer Information"))
       {
            List<Users> userList = usersEJB.findUsers("select u from Users u where u.USID <> " + customerId);
            boolean check = true;
            for(int i = 0; i < userList.size(); i++)
            {
                Users users = userList.get(i);
                if(customer.getEmail().trim().equals(users.getEmail().trim()))
                {
                    check = false;
                    break;
                }
            }
            if(check == true)
            {
                boolean checkBillingAddress = customerEJB.updateBillingAddress(billingAddress);
                boolean checkShippingAddress = customerEJB.updateShippingAddress(shippingAddress);
                customer.setBillingAddress(billingAddress);
                customer.setShippingAddress(shippingAddress);
                boolean checkCustomer = customerEJB.updateCustomer(customer);
                if(checkBillingAddress == true && checkShippingAddress == true && checkCustomer == true)
                {
                    customerList = customerEJB.findCustomers("select c from Customer c");
                    showMessage("Successful","Congratulation, your account has been updated successful");
                }
                else
                {
                    showMessage("Error Message","Data cannot persist");
                }
            }
            else
            {
                showMessage("Duplicated", "This email address has existed, please use another one");
            }
       }
       
   }
   
   public void showCreateDialog()
   {
       customer.setEmail("");
       customer.setFirstName("");
       customer.setLastName("");
       customer.setDateOfBirth(new Date());
       customer.setPhoneNbr("");
       billingAddress.setStreet("");
       billingAddress.setSuburb("");
       billingAddress.setAddressState("");
       billingAddress.setPostcode("");
       shippingAddress.setStreet("");
       shippingAddress.setSuburb("");
       shippingAddress.setAddressState("");
       shippingAddress.setPostcode("");
       
       title = "Create New Customer";
       validate = false;
   }
   
   public void showEditDialog(Long id)
   {
       customerId = id;
       customer = customerEJB.findCustomerWithId("select c from Customer c where c.USID = " + customerId);

       billingAddress = customerEJB.findBillingAddress("select b from Customer As c JOIN c.billingAddress As b where c.USID = " + customerId);
       shippingAddress = customerEJB.findShippingAddress("select s from Customer As c JOIN c.shippingAddress As s where c.USID = " + customerId);
       
       title = "Edit Customer Information";
       validate = true;
   }
   
   public boolean checkEmployeeEmailExisted()
    {
        List<Users> userList = usersEJB.findUsers("select u from Users u");
        boolean check = true;
        for(int i = 0; i < userList.size(); i++)
        {
            Users users = userList.get(i);
            if(employee.getEmail().trim().equals(users.getEmail().trim()))
            {
                check = false;
                break;
            }
        }
        return check;

    }

    public String doCreateEmployee()
    {
           boolean check = checkEmployeeEmailExisted();
           if(check == true)
           {
               try
               {
                   boolean checkEmployee = employeeEJB.createEmployee(employee);
                   if(checkEmployee == true)
                   {
                       employeeList = employeeEJB.findEmployees("select e from Employee e");
                       showMessage("Successful","Congratulation, an account has been created successful");                
                   }
                   else
                   {
                       showMessage("Error Message","Data cannot persist");
                   }
               }
               catch(Exception e)
               {
                  showMessage("Error Message","Data cannot persist to database");
               }
           }
           else
           {
                 showMessage("Duplicated", "This email address has existed, please use another one");

           }
           return "";
    }

    public void showMessage(String str1, String str2)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, str1, str2));
    }


    public String onFlowProcess(FlowEvent event)
    {
	if(skip)
        {
            skip = false;	//reset in case user goes back
            return "confirm";
	}
	else
        {
            return event.getNewStep();
	}
    }
    
    public void onCustomerEdit(RowEditEvent event) 
    {  
        Long id = Long.parseLong(((Customer) event.getObject()).getUSID().toString());
        List<Users> userList = usersEJB.findUsers("select u from Users u where u.USID <> " + id);
        boolean check = true;
        for(int i = 0; i < userList.size(); i++)
        {
            Users users = userList.get(i);
            if(((Customer) event.getObject()).getEmail().toString().trim().equals(users.getEmail().trim()))
            {
                check = false;
                break;
            }
        }
        if(check == true)
        {
            
            Customer c = customerEJB.findCustomerWithId("select c from Customer c where c.USID = " + id);
            c.setEmail(((Customer) event.getObject()).getEmail().toString());
            c.setFirstName(((Customer) event.getObject()).getFirstName().toString());
            c.setLastName(((Customer) event.getObject()).getLastName().toString());
            Date date;
            try
            {
                date = format.parse(((Customer) event.getObject()).getLastName().toString());
            }
            catch(Exception e)
            {
                date = new Date();
            }
            c.setDateOfBirth(date);
            c.setPhoneNbr(((Customer) event.getObject()).getPhoneNbr().toString());
            boolean checkCustomer = customerEJB.updateCustomer(c);
            
            if(checkCustomer == true)
            {
                customerList = customerEJB.findCustomers("select c from Customer c");
                showMessage("Item edited", "Item edited");
            }
            else
            {
                showMessage("Fail to edit", "Fail to edit"); 
            }
        }
        else
        {
            showMessage("Duplicated", "This email address has existed, please use another one");
        }
        
        
    }  
      
    public void onCustomerCancel(RowEditEvent event) 
    {  
        
    }
    
    public void onCustomerDelete(Long id)
    { 
        Customer c = customerEJB.findCustomerWithId("select c from Customer c where c.USID = " + id);
        
        boolean checkCustomer = customerEJB.deleteCustomer(c);
        
        if(checkCustomer == true)
        {
            customerList = customerEJB.findCustomers("select c from Customer c");
            showMessage("Item deleted", "Item deleted");
        }
        else
        {
            showMessage("Fail to delete", "Fail to delete");
        }
    }
    
    public void onEmployeeEdit(RowEditEvent event) 
    {  
        Long id = Long.parseLong(((Employee) event.getObject()).getUSID().toString());
        List<Users> userList = usersEJB.findUsers("select u from Users u where u.USID <> " + id);
        boolean check = true;
        for(int i = 0; i < userList.size(); i++)
        {
            Users users = userList.get(i);
            if(((Employee) event.getObject()).getEmail().toString().trim().equals(users.getEmail().trim()))
            {
                check = false;
                break;
            }
        }
        if(check == true)
        {
            
            Employee e = employeeEJB.findEmployeeWithId("select e from Employee e where e.USID = " + id);
            e.setEmail(((Employee) event.getObject()).getEmail().toString());
            e.setFirstName(((Employee) event.getObject()).getFirstName().toString());
            e.setLastName(((Employee) event.getObject()).getLastName().toString());
            e.setPhoneNbr(((Employee) event.getObject()).getPhoneNbr().toString());
            e.setPhoneNbr(((Employee) event.getObject()).getStatus().toString());
            boolean checkEmployee = employeeEJB.updateEmployee(e);
            
            if(checkEmployee == true)
            {
                employeeList = employeeEJB.findEmployees("select e from Employee e");
                showMessage("Item edited", "Item edited");
            }
            else
            {
                showMessage("Fail to edit", "Fail to edit"); 
            }
        }
        else
        {
            showMessage("Duplicated", "This email address has existed, please use another one");
        }
        
        
    }  
      
    public void onEmployeeCancel(RowEditEvent event) 
    {  
        
    }
    
    public void onEmployeeDelete(Long id)
    { 
        Employee e = employeeEJB.findEmployeeWithId("select e from Employee e where e.USID = " + id);
        
        boolean checkEmployee = employeeEJB.deleteEmployee(e);
        
        if(checkEmployee == true)
        {
            employeeList = employeeEJB.findEmployees("select e from Employee e");
            showMessage("Item deleted", "Item deleted");
        }
        else
        {
            showMessage("Fail to delete", "Fail to delete");
        }
    }


    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Customer getCustomer()
    {
	return customer;
    }
    public void setCustomer(Customer customer)
    {
	this.customer = customer;
    }

    public Employee getEmployee()
    {
	return employee;
    }

    public void setEmployee(Employee employee)
    {
    	this.employee = employee;
    }

    public BillingAddress getBillingAddress()
    {
	return billingAddress;
    }
    public void setBillingAddress(BillingAddress billingAddress)
    {
	this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress()
    {
	return shippingAddress;
    }
    public void setShippingAddress(ShippingAddress shippingAddress)
    {
	this.shippingAddress = shippingAddress;
    }

    public boolean isSkip() 
    {
	return skip;
    }

    public void setSkip(boolean skip) 
    {
	this.skip = skip;
    }

    public SimpleDateFormat getFormat()
    {
        return format;
    }
    
    public List<Customer> getCustomerList()
    {
	return customerList;
    }
    public void setCustomerList(List<Customer> customerList)
    {
	this.customerList = customerList;
    }
    
    public List<Employee> getEmployeeList()
    {
	return employeeList;
    }
    public void setEmployeeList(List<Employee> employeeList)
    {
	this.employeeList = employeeList;
    }
    
    public String getTitle()
    {
	return title;
    }
    public void setTitle(String title)
    {
	this.title = title;
    }
    
    public boolean getValidate()
    {
	return validate;
    }
    public void setValidate(boolean validate)
    {
	this.validate = validate;
    }
    
    public Long getCustomerId()
    {
	return customerId;
    }
    public void setCustomerId(Long customerId)
    {
	this.customerId = customerId;
    }
    
    public String[] getRoles()
    {
        return roles;
    }

}