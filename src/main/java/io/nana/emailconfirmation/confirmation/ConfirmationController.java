package io.nana.emailconfirmation.confirmation;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@RestController
@RequestMapping("/api_v3/users")

public class ConfirmationController {

    @Autowired
    ConfirmationService confirmationService;

    @Autowired
    private MailSender mailSender;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody ConfirmationDTO userdata ){

        String fullname = userdata.getFirstname() + " " + userdata.getLastname();
        String email = userdata.email;
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("no-reply@siteworx.ng");
        message.setTo(email);

        String mailContent = "Congrats " + fullname + ", your account has been created successfully";

        message.setText(mailContent);
        ResponseEntity<?> createduser = confirmationService.saveUser(userdata);

        mailSender.send(message);
        return ResponseEntity.ok().body(createduser);
    }
}
