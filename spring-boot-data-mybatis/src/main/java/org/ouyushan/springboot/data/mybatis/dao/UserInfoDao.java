package org.ouyushan.springboot.data.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.ouyushan.springboot.data.mybatis.entity.UserInfo;

import java.util.List;

/**
 * @Description:
 * 与mybatis整合须在mapper接口添加注解，
 * 或者使用@MapperScan在启动类指定扫描路径
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 14:10
 */
public interface UserInfoDao {

    /* 不需要返回主键 */
    @Insert("insert into user_info(user_name,password,age) values (#{userName},#{password},#{age})")
    int add(UserInfo userInfo);

    /* 需要返回主键 - 自增数据库*/
    @Insert("insert into user_info(user_name,password,age) values (#{userName},#{password},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addReturnKeyIncrement(UserInfo userInfo);

    /* 需要返回主键 - 非自增数据库*/
/*    @Insert("insert into user_info(user_name,password,age) values (#{user_name},#{password},#{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    int addReturnKeyNoIncrement(UserInfo userInfo);*/

    @Update("update user_info set user_name = #{userName},password = #{password}, age = #{age} where id = #{id}")
    int update(UserInfo userInfo);

    @Delete("delete from user_info where id = #{id}")
    int delete(Long id);

    @Select("select id,user_name userName,password,age from user_info where id = #{id}")
    UserInfo findUserInfo(Long id);

    @Select("select * from user_info")
    List<UserInfo> findUserInfoList();

}
