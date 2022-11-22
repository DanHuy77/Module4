package com.example.repository;

import com.example.model.EmailSettings;

import java.util.List;

public interface IEmailSettingsRepository {
    List<EmailSettings> showSettings();
    List<String> showLanguage();
    List<Integer> showPageSize();
    EmailSettings show();
    void update(EmailSettings emailSettings);
//    EmailSettings findById(int id);
}
