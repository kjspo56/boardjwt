package com.ted.board.domain.repository;

import com.ted.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
