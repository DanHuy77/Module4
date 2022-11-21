package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    String[] wordList = {"Hello", "World", "Apple"};
    String[] wordList2 = {"Xin chào", "Thế giới", "Quả táo", "Không tìm thấy"};

    @Override
    public String show(String word) {
        String result = "";
        if (word.equals(wordList[0])){
            result = wordList2[0];
        }
        else if (word.equals(wordList[1])){
            result = wordList2[1];
        }
        else if (word.equals(wordList[2])){
            result = wordList2[2];
        }
        else {
            result = wordList2[3];
        }
        return result;
    }
}
