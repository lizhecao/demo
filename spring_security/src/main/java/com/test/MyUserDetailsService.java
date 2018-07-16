package com.test;

import com.test.dao.RoleRepository;
import com.test.dao.UserRepository;
import com.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义获取UserDetails的方法
 * UserDetails 代表了真实的用户，可以提供userName，password，isExpired等信息
 *
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByName(username);
    if (null == user) {
      throw new UsernameNotFoundException("没有这个用户");
    }

    try {
      return new MyUserDetails(user, roleRepository.findByUserId(user.getId()));
    } catch (Exception e) {
      throw new UsernameNotFoundException("这个用户没有角色");
    }
  }
}
