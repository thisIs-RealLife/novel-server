package com.soa.novelcreatorcore.web.services;

import com.soa.novelcreatorcore.web.model.novel.NovelDTO;

import java.util.List;

public interface NovelService {
    List<NovelDTO> getAllNovels();
}
