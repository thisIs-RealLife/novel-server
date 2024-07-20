package com.soa.novelcreatorcore.repository.novel;

import com.soa.novelcreatorcore.repository.model.view.Novel;
import com.soa.novelcreatorcore.repository.service.NovelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NovelRepositoryTest {

    @Autowired
    public NovelRepository novelRepository;

    @Test
    public void test() {
        Long novelId = testCreateAndGetById();
        testUpdate(novelId);
        testGetAllAndDelete();
    }

    private void testGetAllAndDelete() {
        List<Novel> all = novelRepository.getAll();
        if (all.isEmpty()) {
            Novel novel = NovelHelper.createNovelEntity();
            novelRepository.create(novel);
        }
        all = novelRepository.getAll();
        Assertions.assertFalse(all.isEmpty());

        Novel novel = all.get(0);
        Novel fromById = novelRepository.getById(novel.getId());
        Assertions.assertEquals(fromById, novel);

        novelRepository.delete(novel.getId());
        List<Novel> allAfterDelete = novelRepository.getAll();
        Assertions.assertNotEquals(allAfterDelete.size(), all.size());
        Assertions.assertNull(novelRepository.getById(novel.getId()));

    }

    public void testUpdate(Long id) {
        Novel toUpdate = novelRepository.getById(id);
        toUpdate.setImage(new Byte[]{1, 1, 1, 1});
        toUpdate.setChapterCount(1);
        toUpdate.setAmount(1L);
        toUpdate.setAuthor("aa");
        toUpdate.setName("N");
        toUpdate.setDescription("D");
        toUpdate.setImageName("Name2Test");
        novelRepository.update(toUpdate);
        Novel afterUpdate = novelRepository.getById(id);
        Assertions.assertEquals(toUpdate, afterUpdate);
    }


    public Long testCreateAndGetById() {
        Novel novel = NovelHelper.createNovelEntity();
        Long id = novelRepository.create(novel);
        Novel fromBd = novelRepository.getById(id);

        Assertions.assertNotNull(id);
        Assertions.assertEquals(novel, fromBd);
        return id;
    }
}
