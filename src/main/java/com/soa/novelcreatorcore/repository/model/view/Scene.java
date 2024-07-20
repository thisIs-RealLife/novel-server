package com.soa.novelcreatorcore.repository.model.view;

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
    @NonNull
    private Boolean started;
    private Boolean finished;
    private List<Choice> choices;
}
