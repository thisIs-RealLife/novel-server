package com.soa.novelcreatorcore.repository.model.view;

import com.soa.novelcreatorcore.engine.model.ActionType;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    private Long id;
    @NonNull
    private Long sceneId;
    @NonNull
    private ActionType actionType;
    @Nullable
    private String choiceText;
    @Nullable
    private Long nextScene;
    @Nullable
    private Long choiceDataId;
}
