package com.vocboard.vocboardbackend.core.repository;

import com.vocboard.vocboardbackend.core.entity.QABoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QABoardRepository extends JpaRepository<QABoardEntity, Long> {
}
