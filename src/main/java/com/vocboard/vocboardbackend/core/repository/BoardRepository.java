package com.vocboard.vocboardbackend.core.repository;

import com.vocboard.vocboardbackend.core.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
