package com.vehicleManagement.Vehicle.customerController;

import com.vehicleManagement.Vehicle.customerService.CustomerService;
import com.vehicleManagement.Vehicle.customerService.UserService;
import com.vehicleManagement.Vehicle.entity.Customer;
import com.vehicleManagement.Vehicle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer findByCustomerId(@PathVariable("id") Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer,String username,String password){

        return customerService.saveCustomer(customer);

    }

    @PutMapping("/put/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable("id") Long id){
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
         customerService.deleteCustomer(id);
    }




}
