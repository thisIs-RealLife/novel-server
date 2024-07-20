package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.view.Novel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NovelMapper {
    String TABLE_NAME = "e_novel";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(" INSERT INTO " + TABLE_NAME + "(name,author, description, image, image_name, chapter_count, amount)"
            + " VALUES (#{name}, #{author}, #{description}, #{image}, #{imageName}, #{chapterCount}, #{amount})")
    long insert(Novel novel);

    @Select("SELECT FROM " + TABLE_NAME + " WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "author", column = "author"),
            @Result(property = "description", column = "description"),
            @Result(property = "image", column = "image"),
            @Result(property = "imageName", column = "image_name"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "chapterCount", column = "chapter_count")
    })
    Novel get(Long id);

    @Update("UPDATE " + TABLE_NAME + " set name = #{name}, author = #{author}, " +
            "description = #{description}, image = #{image}, image_name = ${imageName}," +
            "chapter_count = #{chapterCount}, amount = #{amount} WHERE id = #{id}")
    void update(Novel novel);

    @Delete("DELETE from " + TABLE_NAME + " WHERE id = #{id}")
    void delete(Long id);
}
