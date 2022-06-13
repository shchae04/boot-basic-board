package com.practice.board.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "userprofile")
@Entity
@Data
public class User {

    @Id
    private String userid;

    private String userpw;

    private String username;
}
