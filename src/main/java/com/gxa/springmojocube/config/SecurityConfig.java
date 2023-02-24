package com.gxa.springmojocube.config;


import com.gxa.springmojocube.filter.JwtAuthenticationTokenFilter;
import com.gxa.springmojocube.handler.AccessDeniedHandlerImpl;
import com.gxa.springmojocube.handler.AuthenticationEntryPointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启权限校验,方法执行前需要校验用户权限
public class SecurityConfig {

   //数据库中密码以加密形式显示
   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
   }
   @Resource//自定义认证过滤器
         JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
   @Resource//自定义处理登入失败过滤器
         AuthenticationEntryPointImpl authenticationEntryPoint;
   @Resource//自定义处理权限不足过滤器
         AccessDeniedHandlerImpl accessDeniedHandlerI;
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
            //关闭csrf
            .csrf().disable()
            //不通过Session获取SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 对于登录接口 允许匿名访问 只能没有token才能访问
            .antMatchers("/user/login","/user/code","/user/login")
            .anonymous()
            //没有token能访问, 有token必须验证
            .antMatchers("/supplier/*","/drug/*","/diagnosis/*")
            .permitAll()
            // 除上面外的所有请求全部需要鉴权认证
            .anyRequest()
            .authenticated()
      ;


      //把jwt认证过滤器放到user过滤器之前
      //http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
      http.addFilterAfter(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
      //将自定义的ExceptionTranslationFilter加入到security过滤链中
      http.exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint)//处理登入失败
            .accessDeniedHandler(accessDeniedHandlerI);//处理权限不足


      return http.build();
   }

   @Resource
   private AuthenticationConfiguration authenticationConfiguration;

   @Bean
   public AuthenticationManager authenticationManager() throws Exception{
      AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
      return authenticationManager;
   }

   //允许多请求地址多加斜杠 比如 /msg/list //msg/list  WebSocket那里会有多个斜杠!
   @Bean
   public HttpFirewall httpFirewall() {
      return new DefaultHttpFirewall();
   }
}
