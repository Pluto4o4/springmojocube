package com.gxa.springmojocube.service.impl;

import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.utils.Result;

public interface UserService {
  Result login(User user);
  Result sendCode(String email);
  Result out();
  Result logon(User user);
}
