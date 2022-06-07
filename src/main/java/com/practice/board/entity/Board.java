package com.practice.board.entity;

import lombok.Data;

import javax.persistence.*;

@SequenceGenerator(name = "id_seq",
                    sequenceName = "id_seq",
        initialValue = 1, allocationSize = 1)
@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "id_seq")
    private Integer id;

    private String title;

    private String content;
}
