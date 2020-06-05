package org.ouyushan.spring.boot.data.mongodb.repository;

import org.ouyushan.spring.boot.data.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/6/2 16:52
 */

@Repository
public class UserDao {
    @Autowired
    public MongoTemplate mongoTemplate;

    public User insert(User user) {
        return mongoTemplate.insert(user);
    }

    public void deleteById(Long id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, User.class);
    }

    public void updateById(User user) {
        Criteria criteria = Criteria.where("id").in(user.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("name",user.getName());
        update.set("createTime",user.getCreateTime());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    public User selectById(Long id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query,User.class);
    }
}
