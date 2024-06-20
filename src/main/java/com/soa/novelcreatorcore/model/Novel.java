package com.soa.novelcreatorcore.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Novel {
    private Long id;

    private String novelName;
    private String novelAuthor;
    private String novelDescription;
    private String novelImage;
    private Set<String> novelCategory;
    private Date novelDate;
    /**
     * Количество глав
     */
    private Integer chapterCount;
    /**
     * Появились новые главы или нет
     */
    private Boolean isUpdate;
    /**
     * Стоимость
     */
    private Long amount;
    /**
     * Главы
     */
    private List<Chapter> chapters;
    /**
     * Пользователи, которые начали проходить новеллу
     */
    private List<Hero> hero;
}
