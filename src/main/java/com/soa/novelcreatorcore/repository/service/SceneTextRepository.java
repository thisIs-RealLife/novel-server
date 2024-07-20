package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.SceneTextMapper;
import com.soa.novelcreatorcore.repository.model.view.SceneText;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SceneTextRepository {
    private final SceneTextMapper sceneTextMapper;

    public SceneText getBySceneId(@NonNull Long sceneId) {
        return sceneTextMapper.getBySceneId(sceneId);
    }

    public SceneText getById(@NonNull Long id) {
        return sceneTextMapper.getBySceneId(id);
    }

    public Long create(@NonNull SceneText sceneText) {
        Long insert = sceneTextMapper.insert(sceneText);
        if (insert == 0) {
            return null;
        }
        return insert;
    }

    public void update(@NonNull SceneText sceneText) {
        if (sceneText.getId() == null) {
            throw new RuntimeException("Id cannot be null");
        }
        sceneTextMapper.update(sceneText);
    }

    public void delete(@NonNull Long id) {
        sceneTextMapper.delete(id);
    }

    public void deleteBySceneId(@NonNull Long sceneId) {
        sceneTextMapper.delete(sceneId);
    }
}
