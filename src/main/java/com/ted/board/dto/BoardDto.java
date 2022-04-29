package com.ted.board.dto;

import com.ted.board.domain.entity.Board;
import jdk.jshell.execution.LoaderDelegate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long idn;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){    //dto에서 필요한 부분을 빌더 패턴을 통해 Entity로 만들어줌.
        Board build = Board.builder()
                .idn(idn)
                .name(name)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long idn, String name, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.idn = idn;
        this.name = name;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
