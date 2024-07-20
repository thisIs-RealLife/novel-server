package com.soa.novelcreatorcore.repository.sceneText;

import com.soa.novelcreatorcore.repository.model.HeroRole;
import com.soa.novelcreatorcore.repository.model.view.SceneText;

public class SceneTextHelper {
    public static SceneText createSceneText(Long sceneId) {
        SceneText sceneText = new SceneText();
        sceneText.setSceneId(sceneId);
        sceneText.setHeroRole(HeroRole.AUTHOR);
        sceneText.setText("Трах тибидох");
        return sceneText;
    }
}
