package com.gxa.springmojocube.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.gxa.springmojocube.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
   static Result result=new Result();
   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
      List<Object> list = new ArrayList<>();
      list.add(HttpStatus.HTTP_UNAUTHORIZED);
      list.add("你的权限不足!");
      Result responseResult = result.ok(list);
      String json = JSON.toJSONString(responseResult);
      try {
         response.setStatus(200);
         response.setContentType("application/json");
         response.setCharacterEncoding("utf-8");
         response.getWriter().print(json);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}