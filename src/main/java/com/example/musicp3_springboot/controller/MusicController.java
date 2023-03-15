package com.example.musicp3_springboot.controller;

import com.example.musicp3_springboot.entity.Music;
import com.example.musicp3_springboot.form.CreateMusicForm;
import com.example.musicp3_springboot.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicRepository musicRepository;
    @RequestMapping("/")
    public String displayHome(){
        return "index";
    }

    @RequestMapping("/list")
    public @ModelAttribute("musics") List<Music> displaylist() {
        List<Music> musics = musicRepository.list();
        return musics;
    }

    @RequestMapping("/add")
    public String displayAdd() {
        return "create-music";
    }

    @PostMapping("/createMusic")
    public String createMusic(@ModelAttribute CreateMusicForm createMusicForm) {
        Music music = new Music();
        music.setTitle(createMusicForm.getTitle());
        music.setDescription(createMusicForm.getDescription());

        return null;

    }




}