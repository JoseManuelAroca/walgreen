package com.example.sen4farming.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String description_es;
    @Column(nullable = false)
    private String description_en;
    @Column(nullable = false)
    private String description_fr;
    @Column(nullable = false)
    private String description01;
    @Column(nullable = false)
    private String description02;
    @Column(nullable = false)
    private String description03;
    @Column(nullable = false)
    private String description04;
    @ManyToOne
    private Menu parent;
    @Column(name = "APP_ORDER")
    private Integer order;
    private Integer active;
    private String url;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;
}
