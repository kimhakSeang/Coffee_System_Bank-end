package com.coffee.system.config.security.model;


import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "token")
@AllArgsConstructor
@NoArgsConstructor
public class EmailToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String token;
	
	@Column(nullable = false)
	private boolean enable;
	
	@ManyToOne(optional = false)
	private RequestLogin userLogin;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "exprired_at", nullable = false)
	private LocalDateTime expiredAt;
	
	private LocalDateTime confirmedAt;
}
