package com.soa.novelcreatorcore.repository.model.view;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Novel {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String author;
    @NonNull
    private String description;
    @NonNull
    private Byte[] image;
    @NonNull
    private String imageName;
    @NonNull
    private Long amount;
    @NonNull
    private Integer chapterCount;
}
