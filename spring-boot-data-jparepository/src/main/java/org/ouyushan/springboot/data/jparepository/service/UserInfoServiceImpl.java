package org.ouyushan.springboot.data.jparepository.service;

import org.ouyushan.springboot.data.jparepository.entity.UserInfo;
import org.ouyushan.springboot.data.jparepository.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 10:58
 */
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /* 增加 */
    @Override
    public UserInfo add(UserInfo userInfo) {
        return this.userInfoRepository.save(userInfo);
    }

    /* 更新 */
    @Override
    public int update(UserInfo userInfo) {
        return this.userInfoRepository.update(userInfo.getUserName(), userInfo.getPassword(), userInfo.getAge(), userInfo.getId());
    }

    /* 删除 */
    @Override
    public void delete(Long id) {
        this.userInfoRepository.deleteById(id);
    }

    /* 根据id查找 */
    @Override
    public UserInfo findUserInfo(Long id) {
        Optional<UserInfo> optional = this.userInfoRepository.findById(id);
        return optional.orElse(new UserInfo());
    }

    /* 获取列表 */
    @Override
    public List<UserInfo> findUserInfoList() {
        return this.userInfoRepository.findAll();
    }

    /* 分页查找 */
    @Override
    public Page<UserInfo> findAll() {
        return this.userInfoRepository.findAllByAgeBefore(50,(PageRequest.of(0, 10)));
    }
}
