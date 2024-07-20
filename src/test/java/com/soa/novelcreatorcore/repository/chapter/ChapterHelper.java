package com.soa.novelcreatorcore.repository.chapter;

import com.soa.novelcreatorcore.repository.model.view.Chapter;

public class ChapterHelper {
    public static Integer index = 0;

    public static Chapter createChapter(Long novelId) {
        Chapter chapter = new Chapter();
        chapter.setIndex(index++);
        chapter.setTitle(("Chapter " + novelId) + index);
        chapter.setNovelId(novelId);
        return chapter;
    }
}
