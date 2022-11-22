package com.example.service.impl;

import com.example.model.EmailSettings;
import com.example.repository.IEmailSettingsRepository;
import com.example.service.IEmailSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSettingsService implements IEmailSettingsService {

    @Autowired
    private IEmailSettingsRepository emailSettingsRepository;

    @Override
    public List<EmailSettings> showSettings() {
        return emailSettingsRepository.showSettings();
    }

    @Override
    public List<String> showLanguage() {
        return emailSettingsRepository.showLanguage();
    }

    @Override
    public List<Integer> showPageSize() {
        return emailSettingsRepository.showPageSize();
    }

    @Override
    public EmailSettings show() {
        return emailSettingsRepository.show();
    }

    @Override
    public void update(EmailSettings emailSettings) {
        emailSettingsRepository.update(emailSettings);
    }
}
