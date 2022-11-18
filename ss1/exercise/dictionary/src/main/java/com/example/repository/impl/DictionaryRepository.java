package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    String[] wordList = {"Hello", "World", "Apple"};

    @Override
    public String show(String word) {
        String result = "";
        if (word.equals(wordList[0])){
            result = "Xin chào";
        }
        else if (word.equals(wordList[1])){
            result = "Thế giới";
        }
        else if (word.equals(wordList[2])){
            result = "Quả táo";
        }
        else {
            result = "Không tìm thấy";
        }
        return result;
    }
}
