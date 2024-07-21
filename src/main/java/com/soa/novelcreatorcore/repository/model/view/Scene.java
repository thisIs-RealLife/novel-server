package com.soa.novelcreatorcore.repository.model.view;

import lombok.*;
import org.springframework.lang.Nullable;

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
    @Nullable
    private Boolean finished;
    @Nullable
    private Long nextScene;
}
