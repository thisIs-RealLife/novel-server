package com.soa.novelcreatorcore.repository.model.view;

import com.soa.novelcreatorcore.repository.model.Hero;
import com.soa.novelcreatorcore.repository.model.HeroRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SceneText {
    private HeroRole hero;
    private String text;
}
