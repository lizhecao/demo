package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

/**
 * 提供自定义的验证方法
 *
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
  @Autowired
  private MyUserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

    // 密码比较
    String password = authentication.getCredentials() + "";
    if (!PasswordEncoderFactories.createDelegatingPasswordEncoder().matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException("密码错误");
    }

    return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }
}
