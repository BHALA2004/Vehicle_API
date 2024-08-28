package com.vehicleManagement.Vehicle.customerService;


import com.vehicleManagement.Vehicle.entity.User;
import com.vehicleManagement.Vehicle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;





//    public User CreateUser(User user){
//        return userRepository.save(user);
//    }

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
               return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found")) ;
            }
        };
    }


}
