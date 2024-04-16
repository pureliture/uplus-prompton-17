package com.vocboard.vocboardbackend.core.entity;

import com.vocboard.vocboardbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.joda.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
// @Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String referral;

    @Column
    private Boolean completed;

    @Temporal(TemporalType.TIME)
    @Column
    private LocalDateTime inquiryDateTime;

    @Temporal(TemporalType.TIME)
    @Column
    private LocalDateTime endDateTime;

    @Column
    private String receptionOffice;

    @Column
    private String product;

    @Column(length = 1000)
    private String question;

    @Column(length = 1000)
    private String answer;

    @Column(length = 1000)
    private String additionalInquiry;

    @Column(length = 1000)
    private String additionalAnswer;

    @Column(length = 1000)
    private String misc;

    @Column
    private String classification;
}
