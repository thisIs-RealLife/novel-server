package com.soa.novelcreatorcore.repository.model.view;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Scene {
    private Long id;
    @NonNull
    private Long chapterId;
    @NonNull
    private Boolean started;
    private Boolean finished;
}
