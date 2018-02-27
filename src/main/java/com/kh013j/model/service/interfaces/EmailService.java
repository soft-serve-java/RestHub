package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Role;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public interface EmailService {
    void sendEmail(SimpleMailMessage email);
}
