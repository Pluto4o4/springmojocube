package com.gxa.springmojocube.filter;

import com.gxa.springmojocube.utils.JwtUtils;
import com.gxa.springmojocube.utils.LoginUser;
import com.gxa.springmojocube.utils.cache.MyCache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
   @Resource
   MyCache myCache;
   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      //1获取token  header的token
      String token = request.getHeader("token");
      if (!StringUtils.hasText(token)) {
         //放行，让后面的过滤器执行
         filterChain.doFilter(request, response);
         return;
      }
      //2解析token,获取userId
      String userId;
      try {
         Map<String, Object> userInfo = JwtUtils.getMemberIdByJwtToken(token);

         userId = (String)userInfo.get("id");
      } catch (Exception e) {
         throw new RuntimeException("token错误,请登入！");
      }

      //3获取用户信息
      LoginUser loginUser = (LoginUser) myCache.get("userId:"+userId,60*60*24L);
      if (Objects.isNull(loginUser)) {
         throw new RuntimeException("当前用户未登录！");
      }

      //4封装Authentication
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
            = new UsernamePasswordAuthenticationToken(loginUser, null, null);//loginUser.getAuthorities()用户权限

      //5存入SecurityContextHolder
      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

      //放行，让后面的过滤器执行
      filterChain.doFilter(request, response);
   }
}

