package com.tradesuite.backend.domain;

import com.tradesuite.backend.domain.enums.SessionType;
import com.tradesuite.backend.domain.enums.TradeDirection;
import com.tradesuite.backend.domain.enums.TradeMode;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_setup_version_rank_id", nullable = false)
    private SetupVersionRank primarySetupVersionRank;

    @Enumerated(EnumType.STRING)
    @Column(name = "trade_mode", nullable = false, length = 20)
    private TradeMode tradeMode;

    @Column(name = "instrument", nullable = false, length = 50)
    private String instrument;

    @Enumerated(EnumType.STRING)
    @Column(name = "direction", nullable = false, length = 10)
    private TradeDirection direction;

    @Column(name = "entered_at", nullable = false)
    private Instant enteredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "session", length = 30)
    private SessionType session;

    @Column(name = "expected_r", precision = 10, scale = 2)
    private BigDecimal expectedR;

    @Column(name = "realized_r", precision = 10, scale = 2)
    private BigDecimal realizedR;

    @Column(name = "full_move_r", precision = 10, scale = 2)
    private BigDecimal fullMoveR;

    @Column(name = "followed_rules")
    private Boolean followedRules;

    @OneToMany(mappedBy = "trade")
    private List<TradeSecondarySetup> secondarySetups = new ArrayList<>();

    protected Trade() {
    }

    public Trade(
        UUID id,
        SetupVersionRank primarySetupVersionRank,
        TradeMode tradeMode,
        String instrument,
        TradeDirection direction,
        Instant enteredAt,
        SessionType session,
        BigDecimal expectedR,
        BigDecimal realizedR,
        BigDecimal fullMoveR,
        Boolean followedRules
    ) {
        this.id = Objects.requireNonNull(id);
        this.primarySetupVersionRank = Objects.requireNonNull(primarySetupVersionRank);
        this.tradeMode = Objects.requireNonNull(tradeMode);
        this.instrument = Objects.requireNonNull(instrument);
        this.direction = Objects.requireNonNull(direction);
        this.enteredAt = Objects.requireNonNull(enteredAt);
        this.session = session;
        this.expectedR = expectedR;
        this.realizedR = realizedR;
        this.fullMoveR = fullMoveR;
        this.followedRules = followedRules;
    }

    public UUID getId() {
        return id;
    }

    public SetupVersionRank getPrimarySetupVersionRank() {
        return primarySetupVersionRank;
    }

    public TradeMode getTradeMode() {
        return tradeMode;
    }

    public String getInstrument() {
        return instrument;
    }

    public TradeDirection getDirection() {
        return direction;
    }

    public Instant getEnteredAt() {
        return enteredAt;
    }

    public SessionType getSession() {
        return session;
    }

    public BigDecimal getExpectedR() {
        return expectedR;
    }

    public BigDecimal getRealizedR() {
        return realizedR;
    }

    public BigDecimal getFullMoveR() {
        return fullMoveR;
    }

    public Boolean getFollowedRules() {
        return followedRules;
    }

    public List<TradeSecondarySetup> getSecondarySetups() {
        return List.copyOf(secondarySetups);
    }
}