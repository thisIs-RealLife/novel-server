package com.soa.novelcreatorcore.repository.scene;

import com.soa.novelcreatorcore.repository.model.view.Scene;

public class SceneHelper {
    public static Scene getScene(Long chapterId) {
        Scene scene = new Scene();
        scene.setFinished(false);
        scene.setStarted(true);
        scene.setChapterId(chapterId);
        return scene;
    }
}
