package com.soa.novelcreatorcore.engine.model;

public class Action {
    private Long id;
    private Long sequenceNumber;
    private String data; //? данные любого формата для отработки экшна
    private ActionType actionType;
}
