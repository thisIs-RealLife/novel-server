package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.ChoiceMapper;
import com.soa.novelcreatorcore.repository.model.view.Choice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ChoiceRepository {
    private final ChoiceMapper choiceMapper;

    public Long create(Choice choice) {}
}
