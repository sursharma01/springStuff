package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.dao.CustomerDAOImpl;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomerService() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerid}")
    public Customer getCustomerWithId(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerid}")
    public String deleteCustomer(@PathVariable int custumerId){
        if(customerService.getCustomer(custumerId) == null){
            throw new CustomerNotFoundException("Customer does not exist "+custumerId);
        }
        customerService.deleteCustomer(custumerId);
        return "Customer is deleted with id - "+custumerId;
    }
}
