package com.vehicleManagement.Vehicle;
import com.vehicleManagement.Vehicle.entity.Role;
import com.vehicleManagement.Vehicle.entity.User;
import com.vehicleManagement.Vehicle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.vehicleManagement.Vehicle")
public class VehicleManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VehicleManagementApplication.class, args);
	}

	public void run(String...args )
	{
		User adminAccount=userRepository.findByRole(Role.ADMIN);
		if(null==adminAccount)
		{
			User user=new User();

			user.setEmail("admin@gmail.com");
			user.setUsername("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);



		}

	}

}
