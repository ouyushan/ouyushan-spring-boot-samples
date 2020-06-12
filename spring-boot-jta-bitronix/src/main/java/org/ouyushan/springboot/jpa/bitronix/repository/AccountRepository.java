package org.ouyushan.springboot.jpa.bitronix.repository;

import org.ouyushan.springboot.jpa.bitronix.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/10 10:40
 */
public interface AccountRepository extends JpaRepository<Account,Long> {

}
