package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.engine.model.ActionType;
import com.soa.novelcreatorcore.repository.model.view.Choice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumTypeHandler;

import java.util.List;

@Mapper
public interface ChoiceMapper {

    String TABLE_NAME = "e_choice";
    String RESULT = "ChoiceResult";

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO " + TABLE_NAME + " (choice_text, choice_data_id, action_type, scene_id, next_scene_id) " +
            "VALUES (#{choiceText}, #{choiceDataId}, #{actionType, javaType=com.soa.novelcreatorcore.engine.model.ActionType, typeHandler=org.apache.ibatis.type.EnumTypeHandler}, " +
            "#{sceneId}, #{nextScene})")
    long createChoice(Choice choice);

    @Update("UPDATE " + TABLE_NAME + " set scene_id = #{sceneId}, next_scene_id = #{nextScene}," +
            " choice_text = #{choiceText}, choice_data_id = #{choiceDataId}," +
            " action_type = #{actionType, javaType=com.soa.novelcreatorcore.engine.model.ActionType, typeHandler=org.apache.ibatis.type.EnumTypeHandler}"
            + " WHERE id = #{id}")
    void update(Choice choice);

    @Select(" SELECT * from " + TABLE_NAME + " where id = #{id}")
    @Results(id = RESULT, value = {
            @Result(column = "id", property = "id"),
            @Result(column = "choice_text", property = "choiceText"),
            @Result(column = "scene_id", property = "sceneId"),
            @Result(column = "next_scene_id", property = "nextScene"),
            @Result(column = "action_type", property = "actionType", javaType = ActionType.class, typeHandler = EnumTypeHandler.class),
    })
    Choice get(Long id);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE scene_id = #{sceneId}")
    @ResultMap(RESULT)
    List<Choice> getBySceneId(Long sceneId);

    @Delete("DELETE from " + TABLE_NAME + " where id = #{id}")
    void delete(Long id);
}
