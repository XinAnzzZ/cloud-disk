package com.alibaba.guapi.mapper;

import com.alibaba.guapi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XinAnzzZ
 * @date 2018/8/25 0025 16:17
 */
@ContextConfiguration("classpath:spring.xml")
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
    }
}