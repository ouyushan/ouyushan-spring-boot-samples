package org.ouyushan.springboot.jpa.bitronix.controller;

import org.ouyushan.springboot.jpa.bitronix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/10 10:55
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/createAccountAndNotify")
    public void createAccountAndNotify() throws InterruptedException {
        accountService.createAccountAndNotify("josh");
        System.out.println("############Count is############" + accountService.count());
        try {
            accountService.createAccountAndNotify("error");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("=============Count is =============" + accountService.count());
        Thread.sleep(100);
        accountService.deleteAll();
        System.out.println("=============Count is =============" + accountService.count());
    }

    @GetMapping("/deleteAll")
    public void deleteAll() throws InterruptedException {
        accountService.deleteAll();
        System.out.println("=============Count is =============" + accountService.count());
        Thread.sleep(100);
    }
}
