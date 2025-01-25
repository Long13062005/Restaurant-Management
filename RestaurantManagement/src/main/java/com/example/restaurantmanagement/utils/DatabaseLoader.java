package com.example.restaurantmanagement.utils;

import com.example.restaurantmanagement.model.Roles;
import com.example.restaurantmanagement.model.Users;
import com.example.restaurantmanagement.repository.RolesRepository;
import com.example.restaurantmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Load data
        if (rolesRepository.findByName("ADMIN") == null) {
            Roles adminRole = new Roles();
            adminRole.setName("ADMIN");
            rolesRepository.save(adminRole);
        }
        if (rolesRepository.findByName("EMPLOYEE") == null) {
            Roles employeeRole = new Roles();
            employeeRole.setName("EMPLOYEE");
            rolesRepository.save(employeeRole);
        }
        if (rolesRepository.findByName("CUSTOMER") == null) {
            Roles customerRole = new Roles();
            customerRole.setName("CUSTOMER");
            rolesRepository.save(customerRole);
        }

        if (userRepository.findByUsername("admin123").isEmpty()) {
            Users admin = new Users();
            Roles adminRole = rolesRepository.findByName("ADMIN");
            admin.setUsername("admin123");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin123@gmail.com");
            admin.setPhoneNumber("0123456789");
            admin.setDateOfBirth("2005/01/01");
            admin.setRoles(adminRole);
            userRepository.save(admin);
        }

        if (userRepository.findByUsername("customer123").isEmpty()) {
            Users customer = new Users();
            Roles customerRole = rolesRepository.findByName("CUSTOMER");
            customer.setUsername("customer123");
            customer.setPassword(passwordEncoder.encode("customer123"));
            customer.setEmail("customer123@gmail.com");
            customer.setPhoneNumber("0987654321");
            customer.setDateOfBirth("2000/01/01");
            customer.setRoles(customerRole);
            userRepository.save(customer);
        }

        if (userRepository.findByUsername("employee123").isEmpty()) {
            Users employee = new Users();
            Roles employeeRole = rolesRepository.findByName("EMPLOYEE");
            employee.setUsername("employee123");
            employee.setPassword(passwordEncoder.encode("employee123"));
            employee.setEmail("employee123@gmail.com");
            employee.setPhoneNumber("1234567890");
            employee.setDateOfBirth("1995/01/01");
            employee.setRoles(employeeRole);
            userRepository.save(employee);
        }
    }
}