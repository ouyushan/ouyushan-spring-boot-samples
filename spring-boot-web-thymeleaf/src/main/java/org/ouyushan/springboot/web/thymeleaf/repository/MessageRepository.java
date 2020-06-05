package org.ouyushan.springboot.web.thymeleaf.repository;

import org.ouyushan.springboot.web.thymeleaf.entity.Message;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/4/29 14:35
 */
public interface MessageRepository {

    Iterable<Message> findAll();

    Message save(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);

}
