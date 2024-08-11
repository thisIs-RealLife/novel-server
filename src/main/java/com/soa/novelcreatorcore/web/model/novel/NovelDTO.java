package com.soa.novelcreatorcore.web.model.novel;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NovelDTO {
    private Long id;
    private String name;
    private String author;
    private String description;
    private Byte[] image;
    private String imageName;
    private Long amount;
    private Integer chapterCount;
}
