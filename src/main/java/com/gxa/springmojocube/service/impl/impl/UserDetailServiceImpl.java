package com.gxa.springmojocube.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.mapper.UserMapper;
import com.gxa.springmojocube.utils.LoginUser;
import com.gxa.springmojocube.utils.cache.MyCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
   @Resource
   UserMapper userMapper;

   @Resource
   MyCache.MyCache myCache;
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //获取数据库中的用户
      LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
      lambdaQueryWrapper.eq(User::getName, username);
      User user=userMapper.selectOne(lambdaQueryWrapper);
      if(Objects.isNull(user)){
         myCache.put("stat","用户或密码错误!");
         throw new RuntimeException("用户不存在!");
      }
      //查询权限信息
//      List<String> list =menuMapper.selectPermsByUserId(sysUser.getId());
      ArrayList<String> list = new ArrayList<>();
      //返回userDtails
      return new LoginUser(user,list);
   }
}
