package com.eventui.customer.tracking.club.customertrackerclub.controller;


import com.eventui.customer.tracking.club.customertrackerclub.entity.User;
import com.eventui.customer.tracking.club.customertrackerclub.model.UserDto;
import com.eventui.customer.tracking.club.customertrackerclub.service.EmailService;
import com.eventui.customer.tracking.club.customertrackerclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PasswordController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<String> processForgotPasswordForm(@RequestParam("email") String userEmail, HttpServletRequest request) {

        // Lookup user in database by e-mail
        Optional<UserDto> optional = userService.findUserByEmail(userEmail);

        if (!optional.isPresent()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("We didn't find an account for that e-mail address.");
        } else {

            // Generate random 36-character string token for reset password
            UserDto user = optional.get();
            user.setResetToken(UUID.randomUUID().toString());

            // Save token to database
            userService.update(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("support@demo.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
                    + "/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);

            // Add success message to view
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("A password reset link has been sent to " + userEmail);
        }
    }
}
