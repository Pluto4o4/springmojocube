package com.gxa.springmojocube.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.gxa.springmojocube.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
//
public class LoginUser implements UserDetails {
   User user;
   List<String> permissions;//用户权限集合
   @JSONField(serialize = false)//不序列化,不会放到redis中
   List<SimpleGrantedAuthority> authorities;//用户权限集合

   public LoginUser(User user, List<String> permissions) {
      this.user = user;
      this.permissions = permissions;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      //如果不是第一次来
      if(authorities!=null){
         return authorities;
      }
//      List<SimpleGrantedAuthority> list=new ArrayList<>();
//      for (String permission : permissions) {
//         SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(permission);
//         list.add(simpleGrantedAuthority);
//      }
      //和上面的一样
      authorities=permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
      return authorities;
   }

   @Override
   public String getPassword() {
      return user.getPwd();
   }

   @Override
   public String getUsername() {
      return user.getName();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
