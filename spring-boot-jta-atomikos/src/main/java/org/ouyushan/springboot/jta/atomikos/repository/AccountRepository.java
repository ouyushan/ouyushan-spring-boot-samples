package org.ouyushan.springboot.jta.atomikos.repository;

import org.ouyushan.springboot.jta.atomikos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 16:43
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}
