package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.SceneMapper;
import com.soa.novelcreatorcore.repository.model.view.Scene;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)

public class SceneRepository {

    private final SceneMapper sceneMapper;

    public Long createScene(@NonNull Scene scene) {
        long insert = sceneMapper.insert(scene);
        if (insert == 0) {
            return null;
        }
        return scene.getId();
    }

    public Scene getScene(@NonNull Long id) {
        return sceneMapper.getById(id);
    }

    public void updateScene(@NonNull Scene scene) {
        if (scene.getId() == null) {
            throw new IllegalArgumentException("Scene id cannot be null");
        }
        sceneMapper.update(scene);
    }
    public void deleteScene(@NonNull Long id) {
        sceneMapper.deleteById(id);
    }

    public List<Scene> getAllScenes(@NonNull Long chapterId) {
        return sceneMapper.getByChapterId(chapterId);
    }
}
