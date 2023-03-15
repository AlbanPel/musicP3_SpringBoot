package com.example.musicp3_springboot.repository;

import com.example.musicp3_springboot.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Music> list(){
        return jdbcTemplate.query("SELECT MUSIC_ID, TITLE, DESCRIPTION FROM MUSIC",
                (rs, rowNum) -> new Music(
                        String.valueOf(rs.getLong("MUSIC_ID")),
                        rs.getString("TITLE"),
                        rs.getString("DESCRIPTION")
                ));
    }

    //add
    public int add (Music music) {
        return jdbcTemplate.update("INSERT INTO MUSIC ( title, description) VALUES(?,?)",
                new Object[]{
                     music.getTitle(), music.getDescription()
                });

        };
}