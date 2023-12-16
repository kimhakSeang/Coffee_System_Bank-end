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

import com.coffee.system.config.security.dto.TokenDto;
import com.coffee.system.config.security.mapper.TokenMapper;
import com.coffee.system.config.security.model.Token;
import com.coffee.system.config.security.repository.TokenRepository;
import com.coffee.system.config.security.service.TokenService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {
	private final TokenRepository emailRepository;
    private final JavaMailSender mailSender;
    private final TokenMapper emailMapper;
    private final SpringTemplateEngine templateEngine;
    
    private String template = "email_form.html";
    
	@Override
	public String signUp(TokenDto emailTokenDto) {
		String token = UUID.randomUUID().toString();
		emailTokenDto.setEnable(false);
		emailTokenDto.setCreatedAt( LocalDateTime.now());
		emailTokenDto.setExpiredAt( LocalDateTime.now().plusMinutes(15));
		emailTokenDto.setToken(token);
		
		Token emailToken = emailMapper.toEmailToken(emailTokenDto);
		emailRepository.save(emailToken);
		System.out.println(">>>>>>>>>> Done register Email!");
		return token;
	}

	@Override
	public void confirm(String token) {
		Optional<Token> emailToken = emailRepository.findEmailTokenByToken(token);
		if(emailToken.isEmpty()) {
			throw new RuntimeException("Invalid token!");
		}
		Token emailverify = emailToken.get();
		emailverify.setEnable(true);
		emailverify.setConfirmedAt(LocalDateTime.now());
		emailRepository.save(emailverify);
	}

	@Override
	public void sender(Token emailToken, String subject) {
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
            helper.setTo(subject);
            helper.setSubject("Confirm login");
            helper.setFrom("coffe.shop.niche@gmail.com");
            
            
            mailSender.send(mimeMessage);
            
        } catch (MessagingException e) {
            log.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
	}
	
	@Override
	public Token findEmailByToken(String token) {
		 Optional<Token> findEmailByToken = emailRepository.findEmailTokenByToken(token);
		 if(findEmailByToken.isEmpty()) {
			 throw new RuntimeException("This token is not exist!");
		 }
		return findEmailByToken.get();
	}

	@Override
	public List<Token> getAll() {
		return emailRepository.findAll();
	}

	@Override
	public boolean isVerify(String email) {
		
		Optional<Token> getEmial = emailRepository.findEmailTokenByEmail(email);
		
		if(getEmial.isEmpty() ) {
			throw new RuntimeExceptionImpl(ErrorUtil.BAD_REQUEST,"Email not found!");
		}
		if(!getEmial.get().isEnable()) {
			throw new RuntimeExceptionImpl(ErrorUtil.BAD_REQUEST,"Email not yet verify!");
		}
		return true;
	}

	@Override
	public Optional<Token> getEmailTokenByEmail(String email) {
		return emailRepository.findEmailTokenByEmail(email);
	}

}
