package com.tradesuite.backend.domain;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "setup_families")
public class SetupFamily {

    @Id
    private UUID id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "family")
    private List<SetupVariant> variants = new ArrayList<>();

    protected SetupFamily() {
    }

    public SetupFamily(UUID id, String name, String description) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<SetupVariant> getVariants() {
        return List.copyOf(variants);
    }
}