package com.winged.backend.services;

import com.winged.backend.entities.Role;

import java.util.List;

public interface RoleService {
    String addNewRole(Role role);
    List<Role> allRoles();
    Role roleById(int id);
}
