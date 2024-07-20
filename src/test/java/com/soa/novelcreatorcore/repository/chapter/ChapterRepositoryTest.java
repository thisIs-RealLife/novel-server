package com.soa.novelcreatorcore.repository.chapter;

import com.soa.novelcreatorcore.repository.Proxy;
import com.soa.novelcreatorcore.repository.model.view.Chapter;
import com.soa.novelcreatorcore.repository.model.view.Novel;
import com.soa.novelcreatorcore.repository.service.ChapterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChapterRepositoryTest {
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private Proxy proxy;

    @Test
    public void test() {
        Chapter chapter = createChapter();

        updateChapter(chapter);

        deleteByNovel(chapter);
    }

    private void deleteByNovel(Chapter chapter) {
        Long novelId = chapter.getNovelId();
        List<Chapter> all = chapterRepository.getByNovelId(novelId);
        Assertions.assertFalse(all.isEmpty());
        chapterRepository.delete(chapter.getId());
        List<Chapter> allAfterDelete = chapterRepository.getByNovelId(novelId);
        Assertions.assertTrue(allAfterDelete.size() < all.size());
    }

    private void updateChapter(Chapter chapter) {
        Novel novel = proxy.createNovel();
        chapter.setNovelId(novel.getId());
        chapter.setTitle("UPDATETEST");
        chapter.setIndex(23);
        chapterRepository.update(chapter);
        Chapter byId = chapterRepository.getById(chapter.getId());
        Assertions.assertEquals(chapter, byId);
    }

    private Chapter createChapter() {
        Novel novel = proxy.createNovel();
        Chapter chapter = ChapterHelper.createChapter(novel.getId());
        Long chapterId = chapterRepository.create(chapter);
        Chapter fromBd = chapterRepository.getById(chapterId);
        Assertions.assertEquals(chapter, fromBd);
        return chapter;
    }
}
