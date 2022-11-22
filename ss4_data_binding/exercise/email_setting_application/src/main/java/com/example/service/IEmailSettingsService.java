package com.example.service;

import com.example.model.EmailSettings;

import java.util.List;

public interface IEmailSettingsService {
    List<EmailSettings> showSettings();
    List<String> showLanguage();
    List<Integer> showPageSize();
    EmailSettings show();
    void update(EmailSettings emailSettings);
}
