package org.ouyushan.springboot.data.crudrepository.repository;

import org.ouyushan.springboot.data.crudrepository.entity.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/7 17:34
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select id, first_name, date_of_birth from customer where upper(first_name) like '%' || upper(:name) || '%' ")
    List<Customer> findByName(@Param("name") String name);

}
