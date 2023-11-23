package com.coffee.system.config.security.service.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.coffee.system.config.security.dto.EmailTokenDto;
import com.coffee.system.config.security.mapper.EmailMapper;
import com.coffee.system.config.security.model.EmailToken;
import com.coffee.system.config.security.repository.EmailRepository;
import com.coffee.system.config.security.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
	private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;
    private final EmailMapper emailMapper;
    private final SpringTemplateEngine templateEngine;
    
    private String template = "email_form.html";
    
	@Override
	public String signUp(EmailTokenDto emailTokenDto) {
		String token = UUID.randomUUID().toString();
		emailTokenDto.setEnable(false);
		emailTokenDto.setCreatedAt( LocalDateTime.now());
		emailTokenDto.setExpiredAt( LocalDateTime.now().plusMinutes(15));
		emailTokenDto.setToken(token);
		
		EmailToken emailToken = emailMapper.toEmailToken(emailTokenDto);
		emailRepository.save(emailToken);
		
		return token;
	}

	@Override
	public void confirm(String token) {
		Optional<EmailToken> emailToken = emailRepository.findEmailTokenByToken(token);
		if(emailToken.isEmpty()) {
			throw new RuntimeException("Invalid token!");
		}
		EmailToken emailverify = emailToken.get();
		emailverify.setEnable(true);
		emailverify.setConfirmedAt(LocalDateTime.now());
		emailRepository.save(emailverify);
	}

	@Override
	public void sender(EmailToken emailToken, String subject) {
		try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            
            String link = "http://localhost:8080/email/confirm?token="+emailToken.getToken();
//            String link = "http://192.168.1.156:8080/email/confirm?token="+emailToken.getToken();
	   		Context context = new Context();
	   		context.setVariable("name", subject);
	   		context.setVariable("link", link);
            String html = templateEngine.process(template, context);
            
            helper.setText(html, true);
            helper.setTo(emailToken.getUserLogin().getEmail());
            helper.setSubject("Confirm your email");
            helper.setFrom("videotrainingcourse@gmail.com");
            
            
            mailSender.send(mimeMessage);
            
        } catch (MessagingException e) {
            log.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
	}
	
	@Override
	public EmailToken findEmailByToken(String token) {
		 Optional<EmailToken> findEmailByToken = emailRepository.findEmailTokenByToken(token);
		 if(findEmailByToken.isEmpty()) {
			 throw new RuntimeException("This token is not exist!");
		 }
		return findEmailByToken.get();
	}

	@Override
	public List<EmailToken> getAll() {
		return emailRepository.findAll();
	}

	@Override
	public boolean isVerify(String email) {
		Optional<EmailToken> getEmial = emailRepository.findEmailTokenByEmail(email);
		if(getEmial.isEmpty() || !getEmial.get().isEnable()) {
			throw new RuntimeException("Email not yet verify!");
		}
		return true;
	}

}
