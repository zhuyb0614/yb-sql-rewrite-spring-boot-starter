package com.github.zhuyb0614;

import com.github.zhuyb0614.mapper.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * @author yunbo.zhu
 * @version 1.0
 * @date 2022/7/22 9:56 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SqlRewriteApplication.class})
@Slf4j
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
//    @Autowired
//    private DataSource dataSource;

    @Test
    public void findById() {
        User user = userDao.findById(1);
        log.info("user {}", user);
    }
}