package com.vehicleManagement.Vehicle.customerService;
import com.vehicleManagement.Vehicle.entity.Customer;
import com.vehicleManagement.Vehicle.entity.Vehicle;
import com.vehicleManagement.Vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private VehicleRepository vehicleRepository;
    @Autowired
    public CustomerServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return vehicleRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {

        return vehicleRepository.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        for(Vehicle vehicle : customer.getVehicles()){
            vehicle.setCustomer(customer);
        }

         return vehicleRepository.save(customer);

    }


    @Override
    public Customer updateCustomer(Customer customer,Long id) {
        Customer existingCustomer = findById(id);
        if (existingCustomer!=null) {
            Customer newCustomer = existingCustomer;

            newCustomer.setFullName(customer.getFullName());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setCompanyName(customer.getCompanyName());
            newCustomer.setPhoneNo(customer.getPhoneNo());
            newCustomer.getVehicles().clear();
            newCustomer.getVehicles().addAll(customer.getVehicles());
            for (Vehicle vehicle : customer.getVehicles()) {
                vehicle.setCustomer(newCustomer);
            }
            return vehicleRepository.save(newCustomer);
        } else {
            throw new RuntimeException("Customer not found with id " + id);


        }
    }

    @Override
    public void deleteCustomer(Long id) {
         vehicleRepository.deleteById(id);
    }
}
