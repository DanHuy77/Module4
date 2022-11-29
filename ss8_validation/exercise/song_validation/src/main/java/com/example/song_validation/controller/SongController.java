package com.example.song_validation.controller;

import com.example.song_validation.model.Song;
import com.example.song_validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService<Song> songService;

    @GetMapping("")
    public String showList(Model model, Pageable pageable) {
        Page<Song> songList = (Page<Song>) songService.findAll(pageable);
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "add";
    }

    @PostMapping("/add")
    public String addSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song, bindingResult);

        if (bindingResult.hasErrors()) {
            return "add";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Added new Song");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Song Edited");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String removeSong(Integer id, RedirectAttributes redirectAttributes) {
        songService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Song Removed");
        return "redirect:/";
    }

}
