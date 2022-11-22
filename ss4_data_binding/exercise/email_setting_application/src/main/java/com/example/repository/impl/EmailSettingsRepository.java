package com.example.repository.impl;

import com.example.model.EmailSettings;
import com.example.repository.IEmailSettingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailSettingsRepository implements IEmailSettingsRepository {
    public static List<EmailSettings> emailSettingsList = new ArrayList<>();
    public static List<String> language = new ArrayList<>();
    public static List<Integer> pageSize = new ArrayList<>();

    static {
        emailSettingsList.add(new EmailSettings(1,"English", 5, false, ""));
        language.add("English");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public List<EmailSettings> showSettings() {
        return emailSettingsList;
    }

    @Override
    public List<String> showLanguage() {
        return language;
    }

    @Override
    public List<Integer> showPageSize() {
        return pageSize;
    }

    @Override
    public EmailSettings show() {
        return emailSettingsList.get(0);
    }

    @Override
    public void update(EmailSettings emailSettings) {
        emailSettingsList.set(0, emailSettings);
    }
}
