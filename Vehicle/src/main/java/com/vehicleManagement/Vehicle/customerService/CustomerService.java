package com.vehicleManagement.Vehicle.customerService;

import com.vehicleManagement.Vehicle.entity.Customer;

import java.util.List;

public interface CustomerService {

     public List<Customer> findAllCustomer();

     Customer findById(Long id);

     public Customer saveCustomer(Customer customer);

     Customer updateCustomer(Customer customer,Long id);

     public void deleteCustomer(Long id);



}
