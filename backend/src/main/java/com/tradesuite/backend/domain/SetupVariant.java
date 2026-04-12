package com.tradesuite.backend.domain;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(
    name = "setup_variants",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_setup_variant_family_name", columnNames = {"family_id", "name"})
    }
)
public class SetupVariant {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private SetupFamily family;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "variant")
    private List<SetupVersion> versions = new ArrayList<>();

    protected SetupVariant() {
    }

    public SetupVariant(UUID id, SetupFamily family, String name, String description) {
        this.id = Objects.requireNonNull(id);
        this.family = Objects.requireNonNull(family);
        this.name = Objects.requireNonNull(name);
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public SetupFamily getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<SetupVersion> getVersions() {
        return List.copyOf(versions);
    }
}