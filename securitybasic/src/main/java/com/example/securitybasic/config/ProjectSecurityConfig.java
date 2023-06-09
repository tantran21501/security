package com.example.securitybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         * Custom Security
         */

        http.authorizeHttpRequests()
                .requestMatchers("/myAccount","/myBalancer","/myCard","/myLoans").authenticated()
                .requestMatchers("/notices","/contact").permitAll()
                .and()
                .formLogin()
                .and().httpBasic();
        return http.build();
        /**
         * Deny all
         */
        /*http.authorizeHttpRequests()
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .and().httpBasic();
        return http.build();*/
        /**
         * Permit all
         */
//        http.authorizeHttpRequests()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .and().httpBasic();
//        return http.build();

    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        /** Create user details 1 use withDefaultPasswordEncoder()
        */
       /* UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin,user);*/
        /** Create user details 2 use NoOpPasswordEncoder Bean
         */
        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
