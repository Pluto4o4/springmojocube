package com.gxa.springmojocube.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.springmojocube.entity.User;

public interface UserMapper extends BaseMapper<User> {
   User qurryAyNameAndPwd(String username,String pwd);
}
