package com.example.securitybasic.config;

import com.example.securitybasic.model.Customer;
import com.example.securitybasic.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SecurityUserDetails implements UserDetailsService {
    CustomerRepository customerRepository;

    public SecurityUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName;
        String password;
        List<GrantedAuthority> authorities;
        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User details not found for this email: " + username);
        } else {
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }

        return new User(userName, password, authorities);
    }
}
