package com.voiceon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authorities implements GrantedAuthority {
  private static final long serialVersionUID = -8123526131047887755L;
  private Long id;
  private String authority;
  private User user;
  
  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  // one-to-one (1-1), one-to-many (1-*), many-to-many (*-*)
  // one-to-many (1-*)
	  // this hirbanate will add the user_id of user into the authorities table
	  // to enforce this: you put foreign key in child table that point into the parent table 
  			// e.g, foreign key >> user_in in the authorities table from the parent table >> users
  @ManyToOne
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}