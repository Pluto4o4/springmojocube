package com.gxa.springmojocube.controller;

import com.gxa.springmojocube.entity.User;
import com.gxa.springmojocube.service.impl.UserService;
import com.gxa.springmojocube.utils.JwtUtils;
import com.gxa.springmojocube.utils.MD5Util;
import com.gxa.springmojocube.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户类
 *
 * @author Mr.Xu/Pluto404
 * @version 1.0
 * @since 2023/2/18 8:57
 */
@RestController
public class UserController {
  private UserService userService;

  @Autowired
  private UserController(UserService userService) {
    this.userService = userService;
  }

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
  @PostMapping("/user/login")
  public Result login(String name, String pwd) {
    // 加密
    String newPwd = MD5Util.MD5(pwd);
    User user = userService.login(name, newPwd);
    if (user != null) {
      Map map = new HashMap<>();
      String token = JwtUtils.getJwtToken(user.getId() + "", user.getName());
      map.put("token", token);
      map.put("username", name);
      return new Result().ok(map);
    } else {
      return new Result().error("用户名或密码不正确");
    }
  }
}
