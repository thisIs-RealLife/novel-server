package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.Role;
import com.soa.novelcreatorcore.repository.model.RoleName;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RoleMapper {
    String TABLE_NAME = "e_role";
    String RESULT = "RoleResult";

    @Insert("INSERT INTO " + TABLE_NAME +
            "(role_name) " +
            "VALUES (#{roleName});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long insert(Role role);

    @Select("SELECT * FROM " + TABLE_NAME +
            " WHERE id = #{id};")
    @Results(id = RESULT, value = {
            @Result(property = "id", column = "id"),
            @Result(property = "roleName", column = "role_name")
    })
    Role getRoleById(Long id);

    @Select("SELECT * FROM " + TABLE_NAME +
            " WHERE role_name = #{roleName};")
    @ResultMap(RESULT)
    Role getRoleByRoleName(RoleName roleName);

    @Delete("DELETE FROM " + TABLE_NAME +
            " WHERE id = #{id};")
    void deleteRoleById(Long id);

    @Delete("DELETE FROM " + TABLE_NAME +
            " WHERE role_name = #{roleName};")
    void deleteRoleByName(RoleName roleName);
}
