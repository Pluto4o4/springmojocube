package com.gxa.springmojocube.service.impl.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.mapper.UserMapper;
import com.gxa.springmojocube.service.impl.UserService;
import com.gxa.springmojocube.utils.*;
import com.gxa.springmojocube.utils.cache.MyCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 实现类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 9:08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
  @Resource
  private UserMapper userMapper;
//  @Autowired(required = false)
//  private UserServiceImpl(UserMapper userMapper){
//    this.userMapper=userMapper;
//  }
  static Result result=new Result();
  @Resource
  AuthenticationManager authenticationManager;
  @Override
  public Result login(User user) {
    result=new Result();
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPwd());
    Authentication authentication=authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    //校验失败
    if(Objects.isNull(authentication)){
      throw new RuntimeException("校验失败");
    }
    LoginUser loginUser =(LoginUser)authentication.getPrincipal();

    String userId = loginUser.getUser().getId().toString();
    myCache.put("userId:"+userId,loginUser,60*60*24L);
    String userName=loginUser.getUser().getName();
    String jwt= JwtUtils.getJwtToken(userId,userName);
    Map<String ,String> map=new HashMap<>();
    map.put("token",jwt);
    map.put("name",userName);
    return result.ok(map);
  }
  @Resource
  MailSenderUtil mailSenderUtil;
  @Resource
  MyCache myCache;
  @Override
  public Result sendCode(String email) {
    result=new Result();
    try {
      String code= RandomUtil.randomNumbers(6);
      mailSenderUtil.sendEmailCode(code,"3109599256@qq.com",email);
      myCache.put("email:"+email,code,60*5L);
    } catch (Exception e) {
      e.printStackTrace();
      return result.error("验证码获取失败");
    }
    return result.ok("验证码发送成功");
  }

  @Override
  public Result out() {
    result=new Result();
    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
    String id=loginUser.getUser().getId().toString();
    System.err.println("退出登录");
    myCache.remove(id);

    return result.ok("用户退出成功");
  }

  @Resource
  PasswordEncoder passwordEncoder;
  @Override
  public Result logon(User user) {
    result=new Result();
    User user1 = query().eq("name", user.getName()).one();
    if(Objects.nonNull(user1))return result.error("用户名存在");


    if(user.getEmail().isEmpty())return result.error("邮箱错误");
    if(!myCache.containsKey("email:"+user.getEmail()))return result.error("邮箱错误");
    if(!myCache.get("email:"+user.getEmail()).equals(user.getCode()))return result.error("验证码错误");

    user.setPwd(passwordEncoder.encode(user.getPwd()));
    userMapper.insert(user);
    return result.ok("注册成功");
  }
}
