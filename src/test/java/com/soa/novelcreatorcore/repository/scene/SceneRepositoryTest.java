package com.soa.novelcreatorcore.repository.scene;

import com.soa.novelcreatorcore.repository.Proxy;
import com.soa.novelcreatorcore.repository.model.view.Chapter;
import com.soa.novelcreatorcore.repository.model.view.Scene;
import com.soa.novelcreatorcore.repository.service.SceneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SceneRepositoryTest {

    @Autowired
    private SceneRepository sceneRepository;
    @Autowired
    private Proxy proxy;

    @Test
    void createScene() {
        Chapter chapter = proxy.createChapter();
        Scene scene = SceneHelper.getScene(chapter.getId());
        Long sceneId = sceneRepository.createScene(scene);
        Scene scenefromBd = sceneRepository.getScene(sceneId);
        Assertions.assertEquals(scene, scenefromBd);

        sceneRepository.updateScene(scene);
        Assertions.assertEquals(scene, sceneRepository.getScene(sceneId));

        List<Scene> allScenes = sceneRepository.getAllScenes(chapter.getId());
        assertFalse(allScenes.isEmpty());

        sceneRepository.deleteScene(sceneId);
        Assertions.assertTrue(sceneRepository.getAllScenes(chapter.getId()).size() < allScenes.size());
    }

}