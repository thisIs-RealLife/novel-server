package com.soa.novelcreatorcore.repository.model.view;

import com.soa.novelcreatorcore.repository.model.HeroRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SceneText {
    private Long id;
    private HeroRole heroRole;
    private String text;
    private Long sceneId;
}
