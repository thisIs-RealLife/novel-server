package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.RoleMapper;
import com.soa.novelcreatorcore.repository.model.Role;
import com.soa.novelcreatorcore.repository.model.RoleName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleRepository {

    private final RoleMapper roleMapper;

    public void insert(Role role) {
        roleMapper.insert(role);
    }

    public Role getRoleById(Long id) {
        return roleMapper.getRoleById(id);
    }

    public Role getRoleByRoleName(RoleName roleName) {
        return roleMapper.getRoleByRoleName(roleName);
    }

    public void deleteRoleById(Long id) {
        roleMapper.deleteRoleById(id);
    }

    public void deleteRoleByName(RoleName roleName) {
        roleMapper.deleteRoleByName(roleName);
    }
}
