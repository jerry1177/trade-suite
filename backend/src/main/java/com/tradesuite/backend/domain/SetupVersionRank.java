package com.tradesuite.backend.domain;

import com.tradesuite.backend.domain.enums.RankType;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(
    name = "setup_version_ranks",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_setup_version_rank", columnNames = {"setup_version_id", "rank"})
    }
)
public class SetupVersionRank {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "setup_version_id", nullable = false)
    private SetupVersion setupVersion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank", nullable = false, length = 20)
    private RankType rank;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @OneToMany(mappedBy = "setupVersionRank")
    private List<SetupVersionRankRule> rankRules = new ArrayList<>();

    protected SetupVersionRank() {
    }

    public SetupVersionRank(UUID id, SetupVersion setupVersion, RankType rank, String notes) {
        this.id = Objects.requireNonNull(id);
        this.setupVersion = Objects.requireNonNull(setupVersion);
        this.rank = Objects.requireNonNull(rank);
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public SetupVersion getSetupVersion() {
        return setupVersion;
    }

    public RankType getRank() {
        return rank;
    }

    public String getNotes() {
        return notes;
    }

    public List<SetupVersionRankRule> getRankRules() {
        return List.copyOf(rankRules);
    }
}