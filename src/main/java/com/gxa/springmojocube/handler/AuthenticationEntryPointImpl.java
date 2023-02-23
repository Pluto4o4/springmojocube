package com.gxa.springmojocube.handler;

import cn.hutool.http.HttpStatus;


import com.alibaba.fastjson.JSON;
import com.gxa.springmojocube.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
   static Result result=new Result();
   @Override
   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
      //给前端ResponseResult 的json
      List<Object> list = new ArrayList<>();
      list.add(HttpStatus.HTTP_UNAUTHORIZED);
      String json = JSON.toJSONString(result.error("请重新登入!(输入正确的账号或密码)"));
      try {
         response.setStatus(401);
         response.setContentType("application/json");
         response.setCharacterEncoding("utf-8");
         response.getWriter().print(json);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}