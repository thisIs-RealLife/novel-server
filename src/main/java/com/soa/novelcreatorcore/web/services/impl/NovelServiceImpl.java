package com.soa.novelcreatorcore.web.services.impl;

import com.soa.novelcreatorcore.repository.model.view.Novel;
import com.soa.novelcreatorcore.repository.service.NovelRepository;
import com.soa.novelcreatorcore.web.model.novel.NovelDTO;
import com.soa.novelcreatorcore.web.services.NovelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NovelServiceImpl implements NovelService {

    private final NovelRepository novelRepository;

    @Override
    public List<NovelDTO> getAllNovels() {
        List<Novel> all = novelRepository.getAll();
        return toNovelDTO(all);
    }

    private List<NovelDTO> toNovelDTO(List<Novel> novels) {
        return novels
                .stream()
                .map(this::toNovelDTO)
                .collect(Collectors.toList());
    }

    private NovelDTO toNovelDTO(Novel novel) {
        NovelDTO novelDTO = new NovelDTO();
        novelDTO.setId(novel.getId());
        novelDTO.setDescription(novel.getDescription());
        novelDTO.setName(novel.getName());
        novelDTO.setAuthor(novel.getAuthor());
        novelDTO.setImage(novel.getImage());
        novelDTO.setChapterCount(novel.getChapterCount());
        novelDTO.setImageName(novel.getImageName());
        return novelDTO;
    }
}
