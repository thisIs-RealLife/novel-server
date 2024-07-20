package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.view.Chapter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChapterMapper {

    String TABLE_NAME = "e_chapter";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO " + TABLE_NAME + " (title, index, novel_id) " +
            "VALUES (#{title}, #{index}, #{novelId})")
    long insert(Chapter chapter);

    @Select("SELECT * FROM " + TABLE_NAME + " where novel_id = #{novelId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "index", column = "index"),
            @Result(property = "novelId", column = "novel_id"),
    })
    List<Chapter> getByNovelId(Long novelId);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    @Result(property = "novelId", column = "novel_id")
    Chapter getById(Long id);

    @Update("UPDATE " + TABLE_NAME + " set" +
            " title = #{title}, index = #{index}, novel_id = #{novelId}")
    void update(Chapter chapter);

    @Delete("DELETE from " + TABLE_NAME + " where id = #{id}")
    void delete(Long id);
}
