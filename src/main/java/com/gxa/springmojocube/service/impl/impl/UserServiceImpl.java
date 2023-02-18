package com.gxa.springmojocube.service.impl.impl;

import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.mapper.UserMapper;
import com.gxa.springmojocube.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 9:08
 */
@Service
public class UserServiceImpl implements UserService {
  private UserMapper userMapper;
  @Autowired(required = false)
  private UserServiceImpl(UserMapper userMapper){
    this.userMapper=userMapper;
  }

  @Override
  public User login(String username, String pwd) {
    User user=userMapper.qurryAyNameAndPwd(username,pwd);
    return user;
  }
}
