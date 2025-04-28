package com.example.notificationservice.service;

import com.example.notificationservice.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
