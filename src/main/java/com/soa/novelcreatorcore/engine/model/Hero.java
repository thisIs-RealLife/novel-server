package com.soa.novelcreatorcore.engine.model;

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
