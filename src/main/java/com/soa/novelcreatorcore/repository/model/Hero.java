package com.soa.novelcreatorcore.repository.model;

import com.soa.novelcreatorcore.engine.model.HeroSet;

/**
 * Нужно хранить состояние каждого героя по главам
 * Герой - он же опльзователь новеллы
 */
public class Hero {
    private Long id;
    private String name;
    private String male;
    private Object gameCharacteristic;
    private HeroSet heroSet;
}
