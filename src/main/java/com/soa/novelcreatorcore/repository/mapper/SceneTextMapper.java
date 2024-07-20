package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.HeroRole;
import com.soa.novelcreatorcore.repository.model.view.SceneText;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

@Mapper
public interface SceneTextMapper {
    String TABLE_NAME = "e_scene_text";

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO " + TABLE_NAME + "(text, hero_role, scene_id)"
            + " VALUES (#{text}, #{heroRole, " +
            "javaType=com.soa.novelcreatorcore.repository.model.HeroRole, typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}, " +
            "#{sceneId})")
    Long insert(SceneText sceneText);

    @Select("SELECT * from " + TABLE_NAME + " where scene_id = #{sceneId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text"),
            @Result(property = "heroRole", column = "hero_role", javaType = HeroRole.class, typeHandler = EnumOrdinalTypeHandler.class),
            @Result(property = "sceneId", column = "scene_id"),
    })
    SceneText getBySceneId(Long sceneId);


    @Select("SELECT * from " + TABLE_NAME + " where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text"),
            @Result(property = "heroRole", column = "hero_role", javaType = HeroRole.class, typeHandler = EnumOrdinalTypeHandler.class),
            @Result(property = "sceneId", column = "scene_id"),
    })
    SceneText getById(Long id);

    @Update("UPDATE " + TABLE_NAME + " SET text = #{text}, hero_role = #{heroRole}, scene_id = #{sceneId}"
    + " WHERE id = ${id}")
    void update(SceneText sceneText);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id}")
    void delete(Long id);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE scene_id = #{sceneId}")
    void deleteBySceneId(Long sceneId);
}
