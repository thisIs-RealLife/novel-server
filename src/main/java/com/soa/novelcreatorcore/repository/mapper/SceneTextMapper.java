package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.view.SceneText;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SceneTextMapper {
    String TABLE_NAME = "e_scene_text";

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO " + TABLE_NAME + "(text, hero_role, scene_id)"
            + " VALUES (#{text}, #{heroRole}, #{sceneId})")
    void insert(SceneText sceneText);

    @Select("SELECT * from " + TABLE_NAME + " where scene_id = #{sceneId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text"),
            @Result(property = "heroRole", column = "hero_role"),
            @Result(property = "sceneId", column = "scene_id"),
    })
    SceneText getBySceneId(Long sceneId);

    @Update("UPDATE " + TABLE_NAME + " SET text = #{text}, hero_role = #{heroRole}, scene_id = #{sceneId}"
    + " WHERE id = ${id}")
    void update(SceneText sceneText);
}
