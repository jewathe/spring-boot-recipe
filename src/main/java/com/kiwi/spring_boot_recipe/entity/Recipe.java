package com.kiwi.spring_boot_recipe.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="recipe")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="category")
    private String category;

    @Column(name="img")
    private String img;

    @Column(name="available")
    private Boolean available;

}
