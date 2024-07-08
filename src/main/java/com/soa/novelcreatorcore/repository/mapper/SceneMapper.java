package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.Scene;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SceneMapper {
    String TABLE_NAME = "e_scene";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO "+ TABLE_NAME + " (text, chapter_id, started)" +
    " VALUES (#{text}, ${chapter_id}, #{started})")
    long insert(Scene scene);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE chapter_id = #{chapterId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text"),
            @Result(property = "chapterId", column = "chapterId"),
            @Result(property = "started", column = "started")
    })
    List<Scene> getByChapterId(Long chapterId);

    @Delete("delete from " + TABLE_NAME + " where id = #{id}")
    void deleteById(Long id);

    @Update("UPDATE " + TABLE_NAME + " set text = #{text}, chapter_id = #{chapterId}, started = #{started}"
    + " WHERE id = #{id}")
    void update(Scene scene);

}
