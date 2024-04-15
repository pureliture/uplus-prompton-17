package com.vocboard.vocboardbackend.core.entity;

import com.vocboard.vocboardbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.Date;

@Entity
@Getter
@SuperBuilder
@Table(name = "image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "referral", nullable = false)
    private String referral;

    @Column(name = "completed")
    private Boolean completed;

    @Temporal(TemporalType.DATE)
    @Column(name = "inquiry_date")
    private LocalDateTime inquiryDateTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDateTime endDateTime;

    @Column(name = "reception_office")
    private String receptionOffice;

    @Column(name = "product")
    private String product;

    @Column(name = "question", length = 1000)
    private String question;

    @Column(name = "answer", length = 1000)
    private String answer;

    @Column(name = "additional_inquiry", length = 1000)
    private String additionalInquiry;

    @Column(name = "additional_answer", length = 1000)
    private String additionalAnswer;

    @Column(name = "misc", length = 1000)
    private String misc;

    @Column(name = "classification")
    private String classification;
}
