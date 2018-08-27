package com.alibaba.guapi.mapper;

import com.alibaba.guapi.entity.UserRole;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:37
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * find by user id
     *
     * @param userId the user id
     * @return the UserRole
     */
    List<UserRole> findByUserId(int userId);
}
