package com.tradesuite.backend.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Table(
    name = "setup_versions",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_setup_version_variant_number", columnNames = {"variant_id", "version_number"})
    }
)
public class SetupVersion {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", nullable = false)
    private SetupVariant variant;

    @Column(name = "version_number", nullable = false)
    private int versionNumber;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "setupVersion")
    private List<SetupVersionRank> ranks = new ArrayList<>();

    protected SetupVersion() {
    }

    public SetupVersion(UUID id, SetupVariant variant, int versionNumber, String notes, Instant createdAt) {
        this.id = Objects.requireNonNull(id);
        this.variant = Objects.requireNonNull(variant);
        this.versionNumber = versionNumber;
        this.notes = notes;
        this.createdAt = Objects.requireNonNull(createdAt);
    }

    public UUID getId() {
        return id;
    }

    public SetupVariant getVariant() {
        return variant;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public String getNotes() {
        return notes;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public List<SetupVersionRank> getRanks() {
        return List.copyOf(ranks);
    }
}