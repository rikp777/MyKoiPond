package com.api.mykoipond.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;


    @Column(nullable = false, updatable = false, unique = true)
    private UUID uid = UUID.randomUUID();

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
}
