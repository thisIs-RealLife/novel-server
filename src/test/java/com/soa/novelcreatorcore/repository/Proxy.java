package com.soa.novelcreatorcore.repository;

import com.soa.novelcreatorcore.repository.chapter.ChapterHelper;
import com.soa.novelcreatorcore.repository.model.view.Chapter;
import com.soa.novelcreatorcore.repository.model.view.Novel;
import com.soa.novelcreatorcore.repository.novel.NovelHelper;
import com.soa.novelcreatorcore.repository.service.ChapterRepository;
import com.soa.novelcreatorcore.repository.service.NovelRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Proxy {

    @Autowired
    private NovelRepository novelRepository;
    @Autowired
    private ChapterRepository chapterRepository;

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
        Long id = novelRepository.create(novelEntity);
        Novel byId = novelRepository.getById(id);
        Assertions.assertNotNull(byId);
        return byId;
    }


}
