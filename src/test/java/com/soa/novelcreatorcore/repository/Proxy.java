package com.soa.novelcreatorcore.repository;

import com.soa.novelcreatorcore.repository.chapter.ChapterHelper;
import com.soa.novelcreatorcore.repository.model.view.Chapter;
import com.soa.novelcreatorcore.repository.model.view.Novel;
import com.soa.novelcreatorcore.repository.model.view.Scene;
import com.soa.novelcreatorcore.repository.novel.NovelHelper;
import com.soa.novelcreatorcore.repository.scene.SceneHelper;
import com.soa.novelcreatorcore.repository.service.ChapterRepository;
import com.soa.novelcreatorcore.repository.service.NovelRepository;
import com.soa.novelcreatorcore.repository.service.SceneRepository;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Proxy {
    private final static Logger log = LoggerFactory.getLogger("CORE");

    @Autowired
    private NovelRepository novelRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private SceneRepository sceneRepository;

    public Scene createScene() {
        Chapter chapter = createChapter();
        Scene scene = SceneHelper.getScene(chapter.getId());
        sceneRepository.createScene(scene);
        return scene;
    }
    public Chapter createChapter() {
        Novel novel = createNovel();
        Chapter chapter = ChapterHelper.createChapter(novel.getId());
        Long id = chapterRepository.create(chapter);
        Assertions.assertNotNull(id);
        Chapter byId = chapterRepository.getById(id);
        Assertions.assertNotNull(byId);
        return byId;
    }

    public Novel createNovel() {
        Novel novelEntity = NovelHelper.createNovelEntity();
        log.info("Novel created: {}", novelEntity);
        Long id = novelRepository.create(novelEntity);
        log.info("Novel created: {}", id);
        Novel byId = novelRepository.getById(id);
        List<Novel> all = novelRepository.getAll();
        log.info("Novels found: {}", all);
        log.info("Novel created: {}", byId);
        Assertions.assertNotNull(byId);
        return byId;
    }


}
