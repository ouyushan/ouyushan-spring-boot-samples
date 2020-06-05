package org.ouyushan.springboot.data.crudrepository.controller;

import org.ouyushan.springboot.data.crudrepository.entity.Customer;
import org.ouyushan.springboot.data.crudrepository.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/7 17:36
 */
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    // 构造注入
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    @Transactional(readOnly = true)
    public List<Customer> customers(@RequestParam String name) {
        return this.customerRepository.findByName(name);
    }
}
