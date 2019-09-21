package com.zby.service.impl;

import com.zby.entity.User;
import com.zby.mapper.UserMapper;
import com.zby.service.UserService;
import com.zby.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUsername(String username) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        sqlSession.close();
        return user;
    }
}
