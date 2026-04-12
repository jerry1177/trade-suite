package com.tradesuite.backend.domain;

import com.tradesuite.backend.domain.enums.RuleType;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "setup_version_rank_rules",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_setup_version_rank_rule",
            columnNames = {"setup_version_rank_id", "rule_id", "rule_type"}
        )
    }
)
public class SetupVersionRankRule {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "setup_version_rank_id", nullable = false)
    private SetupVersionRank setupVersionRank;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false)
    private Rule rule;

    @Enumerated(EnumType.STRING)
    @Column(name = "rule_type", nullable = false, length = 20)
    private RuleType ruleType;

    protected SetupVersionRankRule() {
    }

    public SetupVersionRankRule(UUID id, SetupVersionRank setupVersionRank, Rule rule, RuleType ruleType) {
        this.id = Objects.requireNonNull(id);
        this.setupVersionRank = Objects.requireNonNull(setupVersionRank);
        this.rule = Objects.requireNonNull(rule);
        this.ruleType = Objects.requireNonNull(ruleType);
    }

    public UUID getId() {
        return id;
    }

    public SetupVersionRank getSetupVersionRank() {
        return setupVersionRank;
    }

    public Rule getRule() {
        return rule;
    }

    public RuleType getRuleType() {
        return ruleType;
    }
}