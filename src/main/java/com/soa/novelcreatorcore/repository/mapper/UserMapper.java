package com.soa.novelcreatorcore.repository.mapper;

import com.soa.novelcreatorcore.repository.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    String TABLE_NAME = "e_user";

    @Insert("INSERT INTO " + TABLE_NAME +
            "(login, email, password, role_id) " +
            "VALUES (#{login}, #{email}, #{password}, #{roleId});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("SELECT CASE " +
            " WHEN EXISTS (SELECT 1 FROM " + TABLE_NAME +
            " WHERE login = #{login} OR email = #{login}) THEN TRUE " +
            " ELSE FALSE " +
            " END AS user_exists;")
    boolean userExist(String login);

    @Select("SELECT * FROM " + TABLE_NAME +
    " WHERE login = #{login};")
    @Result(property = "roleId", column = "role_id")
    User getUserByLogin(String login);

    @Select("SELECT * FROM " + TABLE_NAME +
            " WHERE email = #{email};")
    @Result(property = "roleId", column = "role_id")
    User getUserByEmail(String email);
}
