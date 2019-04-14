package com.eventui.customer.tracking.club.customertrackerclub.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    public void sendEmail(SimpleMailMessage email);
}