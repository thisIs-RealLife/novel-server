package com.soa.novelcreatorcore.repository.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scene {
    private Long id;
    @NonNull
    private String text;
    @NonNull
    private Long chapterId;

    private List<Choice> choices;
}
