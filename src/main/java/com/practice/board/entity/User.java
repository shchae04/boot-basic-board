package com.practice.board.entity;

import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "userprofile")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(generator = "user_generator")
    @GenericGenerator(name = "user_generator",strategy = "uuid")
    private String userid;

    private String userpw;

    private String username;
}
