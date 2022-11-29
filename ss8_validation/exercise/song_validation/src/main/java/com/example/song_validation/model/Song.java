package com.example.song_validation.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "[A-Za-z ]{2,800}", message = "Name can not contains special digits and have length from 2 to 800 digits!")
    @NotBlank(message = "Name must be filled")
    @NotNull(message = "Name can not be empty")
    private String songName;
    @Pattern(regexp = "[A-Za-z ]{2,800}", message = "Artist name can not contains special digits and have length from 2 to 300 digits!")
    @NotBlank(message = "Artist must be filled")
    @NotNull(message = "Artist can not be empty")
    private String artist;
    @Pattern(regexp = "[A-Za-z, ]{2,1000}", message = "Genre can not contains special digits, except ',' and have length from 2 to 1000 digits !")
    @NotBlank(message = "Genre must be filled")
    @NotNull(message = "Genre can not be empty")
    private String genre;

    public Song() {
    }

    public Song(Integer id, String songName, String artist, String genre) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
    }
}
