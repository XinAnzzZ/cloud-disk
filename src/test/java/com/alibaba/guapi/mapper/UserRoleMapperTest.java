package com.alibaba.guapi.mapper;

import com.alibaba.guapi.entity.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/9/1 0001 20:21
 */
@ContextConfiguration("classpath:spring.xml")
@RunWith(SpringRunner.class)
public class UserRoleMapperTest {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Test
    public void findByUserId() {
        List<UserRole> userRoleList = userRoleMapper.findByUserId(1);
        System.out.println(userRoleList);
    }
}