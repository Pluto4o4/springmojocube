package com.gxa.springmojocube.mapper;

import com.gxa.springmojocube.entity.User;

public interface UserMapper {
   User qurryAyNameAndPwd(String username,String pwd);
}
