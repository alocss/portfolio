package com.portfolio.formulario.controller; 

import com.portfolio.formulario.dto.ContatoDTO; 
import com.portfolio.formulario.service.EmailService; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contato")
@CrossOrigin(origins = "*")
public class ContatoController{
    private final EmailService emailService;

    public ContatoController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody ContatoDTO contato) {
        emailService.enviarEmail(contato);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");

    }
}