package com.soa.novelcreatorcore.web.controllers;

import com.soa.novelcreatorcore.web.model.novel.NovelDTO;
import com.soa.novelcreatorcore.web.services.NovelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novels")
@AllArgsConstructor
public class NovelController {

    private final NovelService novelService;

    @GetMapping("/all")
    public ResponseEntity<List<NovelDTO>> getAllNovels() {
        return ResponseEntity.ok(novelService.getAllNovels());
    }
}
