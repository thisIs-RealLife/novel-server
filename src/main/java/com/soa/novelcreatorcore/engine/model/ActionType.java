package com.soa.novelcreatorcore.engine.model;

import lombok.Getter;

@Getter
public enum ActionType {
    TEXT(null),
    DO_CHANGE_CLOTHES("e_clothes_data"),
    GAME_CHARACTERISTIC("e_game_characteristic"),
    CHOOSE_ANSWER(null),
    EMOTIONAL_CHANGE(null);

    public final String table;

    ActionType(String table) {
        this.table = table;
    }
}
