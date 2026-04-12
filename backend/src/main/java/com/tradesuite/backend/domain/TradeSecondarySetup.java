package com.tradesuite.backend.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "trade_secondary_setups",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_trade_secondary_setup", columnNames = {"trade_id", "setup_version_rank_id"})
    }
)
public class TradeSecondarySetup {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id", nullable = false)
    private Trade trade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "setup_version_rank_id", nullable = false)
    private SetupVersionRank setupVersionRank;

    protected TradeSecondarySetup() {
    }

    public TradeSecondarySetup(UUID id, Trade trade, SetupVersionRank setupVersionRank) {
        this.id = Objects.requireNonNull(id);
        this.trade = Objects.requireNonNull(trade);
        this.setupVersionRank = Objects.requireNonNull(setupVersionRank);
    }

    public UUID getId() {
        return id;
    }

    public Trade getTrade() {
        return trade;
    }

    public SetupVersionRank getSetupVersionRank() {
        return setupVersionRank;
    }
}