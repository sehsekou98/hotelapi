package org.sekou.lisamhotel.service;

import org.sekou.lisamhotel.model.Role;
import org.sekou.lisamhotel.model.User;

import java.util.List;

public interface RoleServiceImpl {
    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);
}
