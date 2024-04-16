package com.vocboard.vocboardbackend.core.entity;

import com.vocboard.vocboardbackend.common.infrastructure.model.BasePersistenceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "qa_board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QABoardEntity extends BasePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String product;
    @Column
    private String questionType;
    @Column
    private String question;
    @Column
    private String answer;
}
