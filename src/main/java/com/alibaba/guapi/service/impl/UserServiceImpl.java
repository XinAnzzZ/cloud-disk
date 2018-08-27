package com.alibaba.guapi.service.impl;

import com.alibaba.guapi.common.enums.RoleEnum;
import com.alibaba.guapi.common.util.ResponseJson;
import com.alibaba.guapi.common.util.ShiroUtils;
import com.alibaba.guapi.entity.Role;
import com.alibaba.guapi.entity.User;
import com.alibaba.guapi.entity.UserRole;
import com.alibaba.guapi.mapper.UserMapper;
import com.alibaba.guapi.mapper.UserRoleMapper;
import com.alibaba.guapi.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/10 17:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User getUserInfoById(Integer userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User getUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResponseJson register(User user) {
        user.setPassword(ShiroUtils.toMD5(user.getPassword(), user.getUsername()));
        userMapper.save(user);
        UserRole userRole = new UserRole(user.getId(), new Role(RoleEnum.USER.getCode()));
        userRoleMapper.save(userRole);
        return ResponseJson.success();
    }

    @Override
    public ResponseJson getAllUser(int pageNumber, int pageSize, String order) {
        PageInfo<User> userPageInfo = PageHelper.startPage(pageNumber, pageSize, order)
                .doSelectPageInfo(() -> userMapper.findByEntity(null));
        return ResponseJson.success(userPageInfo);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResponseJson deleteUser(List<User> userList) {
        List<Integer> userIdList = new ArrayList<>();
        userList.forEach(user -> userIdList.add(user.getId()));
        userMapper.deleteAllByIdList(userIdList);
        return ResponseJson.success();
    }
}
