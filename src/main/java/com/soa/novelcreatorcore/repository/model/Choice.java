package com.soa.novelcreatorcore.repository.model;

import com.soa.novelcreatorcore.engine.model.ActionType;
import lombok.*;

import java.util.List;

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
    private String choiceText;
    private List<Scene> nextScenes;
    private ActionType actionType;
}
