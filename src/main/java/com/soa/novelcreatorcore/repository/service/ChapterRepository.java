package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.ChapterMapper;
import com.soa.novelcreatorcore.repository.model.view.Chapter;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ChapterRepository {
    private final ChapterMapper chapterMapper;

    public List<Chapter> getByNovelId(@NonNull Long novelId) {
        return chapterMapper.getByNovelId(novelId);
    }

    public Long create(@NonNull Chapter chapter) {
        long insert = chapterMapper.insert(chapter);
        if (insert == 0) {
            return null;
        }
        return chapter.getId();
    }

    public Chapter getById(@NonNull Long chapterId) {
        return chapterMapper.getById(chapterId);
    }

    public void update(@NonNull Chapter chapter) {
        if (chapter.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        chapterMapper.update(chapter);
    }

    public void delete(@NonNull Long chapterId) {
        chapterMapper.delete(chapterId);
    }
}
