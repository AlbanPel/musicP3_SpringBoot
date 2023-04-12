package com.example.musicp3_springboot.api;

import com.example.musicp3_springboot.entity.Music;
import com.example.musicp3_springboot.repository.MusicRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MusicRessource {
    @Autowired
    private MusicRepository musicRepository;

    @RequestMapping(value="apiList", method= RequestMethod.GET)
    public @ResponseBody List<Music> list() {return (List<Music>) musicRepository.list();}

    @GetMapping("api/{id}")
    @ResponseBody
    public Optional<Music> get(@PathVariable("id") Long number) {return Optional.ofNullable(musicRepository.getId(number));}
}
