package com.vehicleManagement.Vehicle.repository;

import com.vehicleManagement.Vehicle.entity.Role;
import com.vehicleManagement.Vehicle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
