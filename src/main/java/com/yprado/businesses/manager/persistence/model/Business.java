package com.yprado.businesses.manager.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "businesses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Business {

    @Id
    @GeneratedValue(strategy = AUTO)
    private String id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "owner_name", nullable = false, length = 255)
    private String ownerName;

    @Column(nullable = false, length = 100)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private BusinessSegment segment;

    @Column(nullable = false, length = 255)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BusinessStatus status;
}