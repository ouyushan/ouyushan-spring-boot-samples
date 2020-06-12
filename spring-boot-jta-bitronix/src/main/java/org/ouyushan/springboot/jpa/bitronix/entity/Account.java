package org.ouyushan.springboot.jpa.bitronix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/10 10:37
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

}
