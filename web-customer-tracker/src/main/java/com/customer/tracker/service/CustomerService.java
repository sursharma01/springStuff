package com.customer.tracker.service;

import com.customer.tracker.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomer();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int theId);
    public void deleteCustomer(int theId);
    public List<Customer> searchCustomers(String theSearchName);
}
