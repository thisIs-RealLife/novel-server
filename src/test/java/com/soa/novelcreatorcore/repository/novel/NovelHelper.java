package com.soa.novelcreatorcore.repository.novel;

import com.soa.novelcreatorcore.repository.model.view.Novel;

public class NovelHelper {
    public static Novel createNovelEntity() {
        Novel novel = new Novel();
        novel.setAmount(100L);
        novel.setAuthor("Iam");
        novel.setName("Name");
        novel.setDescription("Description");
        novel.setChapterCount(2);
        novel.setImageName("ImageName");
        novel.setImage(new Byte[]{0, 1, 2, 3});
        return novel;
    }
}
