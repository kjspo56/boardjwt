package com.ted.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

    @Getter
    @Entity
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @EntityListeners(AuditingEntityListener.class)
    public class Board {

        @Id
        @GeneratedValue
        private Long idn;   //No. 값

        @Column(length = 12, nullable = false)
        private String name;    //사용자 이름

        @Column(length = 100, nullable = false)
        private String title;   //제목

        @Column(columnDefinition = "TEXT", nullable = false)
        private String content; //내용

        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime createdDate;  //생성날짜

        @LastModifiedDate
        private LocalDateTime modifiedDate; //수정날짜

        @Builder
        public Board(Long idn, String name, String title, String content) {
            this.idn = idn;
            this.name = name;
            this.title = title;
            this.content = content;
        }
    }
