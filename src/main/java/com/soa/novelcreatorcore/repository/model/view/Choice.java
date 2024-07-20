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
    private String choiceText;
    private Scene nextScene;
    @Nullable
    private Long choiceDataId;
}
