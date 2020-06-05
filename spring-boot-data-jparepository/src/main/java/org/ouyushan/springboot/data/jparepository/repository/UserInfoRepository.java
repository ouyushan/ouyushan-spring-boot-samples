package org.ouyushan.springboot.data.jparepository.repository;

import org.ouyushan.springboot.data.jparepository.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 10:56
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /* 更新 */
    @Modifying
    @Query("update UserInfo u set  u.userName = ?1, u.password = ?2, u.age = ?3  where u.id = ?4")
    int update(String userName, String password,int age,Long id);

    Page<UserInfo> findAllByAgeBefore(int age,Pageable pageable);
}
