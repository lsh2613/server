package com.pitchain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bm_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private BmCategory category;

    private String logoImg;

    @Column(length = 10000)
    private String description;

    private String descriptionImg;
    private String address;
    private Long valuationCap;
    private LocalDate deadline;
    private String longPitchUrl;

    @OneToMany(mappedBy = "bm")
    private List<Investment> investments = new ArrayList<>();

    @OneToOne(mappedBy = "bm")
    private Sp sp;

    @OneToMany(mappedBy = "bm")
    private List<PtImg> ptImgs = new ArrayList<>();

    @OneToMany(mappedBy = "bm")
    private List<BmTag> bmTags = new ArrayList<>();

    @OneToMany(mappedBy = "bm")
    private List<Comment> comments = new ArrayList<>();
}
