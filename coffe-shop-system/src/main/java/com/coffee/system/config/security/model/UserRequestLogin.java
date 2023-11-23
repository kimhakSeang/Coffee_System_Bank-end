package com.coffee.system.config.security.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_login")
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    private User user;
    
    @Column(nullable = false,  updatable = false)
    private String email;
    
    @Column(nullable = false)
  	private String password;
  	
  	@OneToOne
  	private Role role;
  	
  	private boolean accountNonExpired;
  	private boolean accountNonLocked;
  	private boolean credentialsNonExpired;
  	private boolean enabled;
}
