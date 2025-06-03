package com.portfolio.formulario.service;

import com.portfolio.formulario.dto.ContatoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender; // Certifique-se de ter este import
import org.springframework.stereotype.Service;

@Service
public class EmailService{

    private final JavaMailSender mailSender; // Corrigido para JavaMailSender

    @Value("${spring.mail.username}")
    private String from;

    public EmailService(JavaMailSender mailSender) { // Corrigido no construtor também
        this.mailSender = mailSender;
    }

    public void enviarEmail(ContatoDTO contato) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("alexribeiro.dev@outlook.com");
        message.setSubject("Contato" + contato.getAssunto());
        message.setText("Nome: " + contato.getNome() + "\n" +
                        "Email: " + contato.getEmail() + "\n" +
                        "Mensagem: " + contato.getMensagem());

        mailSender.send(message);
    }
}