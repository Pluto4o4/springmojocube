package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.service.impl.UserService;
import com.gxa.springmojocube.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 8:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

//  @Autowired
//  private UserController(UserService userService) {
//    this.userService = userService;
//  }

  @ApiOperation(value = "登录接口")
  @ApiImplicitParams({
    @ApiImplicitParam(
        paramType = "body",
        name = "username",
        value = "用户名",
        dataType = "String",
        required = true),
    @ApiImplicitParam(
        paramType = "body",
        name = "pwd",
        value = "密码",
        dataType = "String",
        required = true),
  })
  @PostMapping("/login")
  public Result login(@RequestBody User user) {
      return userService.login(user);
  }

  @PostMapping("/code")
  public Result sendCode(@RequestParam(value = "email") String email){
    return userService.sendCode(email);
  }
  @PostMapping("/logout")
  public Result out(){
    return userService.out();
  }

  @PostMapping("/logon")
  public Result logon(@RequestBody User user){
    return userService.logon(user);
  }
}
