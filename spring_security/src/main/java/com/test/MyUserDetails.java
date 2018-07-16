package com.test;

import com.test.model.Role;
import com.test.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author lizhecao 2018/5/17
 * @version 1.0
 */
@Data
public class MyUserDetails extends User implements UserDetails{
  private List<Role> roles;


  public MyUserDetails(User user, List<Role> roles) {
    super(user);
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(roles == null || roles.size() <1){
      return AuthorityUtils.commaSeparatedStringToAuthorityList("");
    }
    StringBuilder commaBuilder = new StringBuilder();
    for(Role role : roles){
      commaBuilder.append(role).append(",");
    }
    String authorities = commaBuilder.substring(0,commaBuilder.length()-1);
    return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getName();
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
