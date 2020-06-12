package org.ouyushan.springboot.jta.atomikos.service;

import org.ouyushan.springboot.jta.atomikos.entity.Account;
import org.ouyushan.springboot.jta.atomikos.repository.AccountRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/9 16:46
 */
@Service
@Transactional
public class AccountService {

    private final JmsTemplate jmsTemplate;

    private final AccountRepository accountRepository;

    public AccountService(JmsTemplate jmsTemplate, AccountRepository accountRepository) {
        this.jmsTemplate = jmsTemplate;
        this.accountRepository = accountRepository;
    }

    public void createAccountAndNotify(String username) {
        this.jmsTemplate.convertAndSend("accounts", username);
        this.accountRepository.save(new Account(username));
        if ("error".equals(username)) {
            throw new RuntimeException("*****************Simulated error*****************");
        }
    }

    public long count(){
        return accountRepository.count();
    }

    public void deleteAll(){
        accountRepository.deleteAll();
    }

}
