package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.User;

public interface UserService {
  User login(String username,String pwd);
}
