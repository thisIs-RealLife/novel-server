package com.soa.novelcreatorcore.repository.sceneText;

import com.soa.novelcreatorcore.repository.Proxy;
import com.soa.novelcreatorcore.repository.model.view.Scene;
import com.soa.novelcreatorcore.repository.model.view.SceneText;
import com.soa.novelcreatorcore.repository.service.SceneTextRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SceneTextHelperRepositoryTest {
    @Autowired
    private SceneTextRepository sceneTextRepository;

    @Autowired
    private Proxy proxy;
    @Test
    public void sceneTextTest() {
        Scene scene = proxy.createScene();
        SceneText sceneText = SceneTextHelper.createSceneText(scene.getId());
        sceneTextRepository.create(sceneText);
        SceneText sceneTextFromBd = sceneTextRepository.getBySceneId(sceneText.getSceneId());
        Assertions.assertEquals(sceneTextFromBd, sceneText);
        Assertions.assertEquals(sceneTextFromBd, sceneTextRepository.getById(sceneTextFromBd.getId()));
        sceneTextRepository.delete(sceneTextFromBd.getId());
        Assertions.assertNull(sceneTextRepository.getBySceneId(sceneText.getSceneId()));
    }
}
