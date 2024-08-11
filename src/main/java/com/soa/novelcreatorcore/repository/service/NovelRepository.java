package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.NovelMapper;
import com.soa.novelcreatorcore.repository.model.view.Novel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class NovelRepository {

    private final NovelMapper novelMapper;

    public List<Novel> getAll() {
        return novelMapper.getAll();
    }

    public Novel getById(Long id) {
        return novelMapper.get(id);
    }

    public Long create(Novel novel) {
        long insert = novelMapper.insert(novel);
        if (insert != 0) {
            return novel.getId();
        }
        return null;
    }

    public void update(Novel novel) {
        if (novel.getId() != null) {
            novelMapper.update(novel);
        } else {
            throw new RuntimeException("Novel id is null");
        }
    }

    public void delete(Long id) {
        novelMapper.delete(id);
    }
}
