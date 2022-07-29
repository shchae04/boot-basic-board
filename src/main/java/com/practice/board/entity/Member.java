package com.practice.board.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "userprofile")
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(generator = "user_generator")
    @GenericGenerator(name = "user_generator",strategy = "uuid")
    private String userid;

    private String userpw;

    private String username;
}
