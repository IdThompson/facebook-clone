package com.example.facebookclone2.models;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class Posts {
    private int postId;
    private String content;
    private int userId;
    private User user;

}


