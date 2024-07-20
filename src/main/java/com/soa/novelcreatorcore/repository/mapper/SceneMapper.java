package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.view.Scene;
import lombok.NonNull;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SceneMapper {
    String TABLE_NAME = "e_scene";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO "+ TABLE_NAME + " (chapter_id, started, finished)" +
    " VALUES (${chapterId}, #{started}, #{finished})")
    long insert(@NonNull Scene scene);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE chapter_id = #{chapterId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "chapterId", column = "chapter_id"),
            @Result(property = "started", column = "started"),
            @Result(property = "finished", column = "finished"),
    })
    List<Scene> getByChapterId(@NonNull Long chapterId);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "chapterId", column = "chapter_id"),
            @Result(property = "started", column = "started"),
            @Result(property = "finished", column = "finished"),
    })
    Scene getById(@NonNull Long id);

    @Delete("delete from " + TABLE_NAME + " where id = #{id}")
    void deleteById(@NonNull Long id);

    @Update("UPDATE " + TABLE_NAME + " set  chapter_id = #{chapterId}, started = #{started}, finished = #{finished}"
    + " WHERE id = #{id}")
    void update(@NonNull Scene scene);

}
