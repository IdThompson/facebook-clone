package com.example.facebookclone2.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private String passWord;

//    public User(String userName, String email, String firstName, String lastName, String country, String passWord) {
//        this.userName = userName;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.country = country;
//        this.passWord = passWord;
//    }
}
