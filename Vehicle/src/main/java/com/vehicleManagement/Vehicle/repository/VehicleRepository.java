package com.vehicleManagement.Vehicle.repository;

import com.vehicleManagement.Vehicle.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Customer,Long> {
}
