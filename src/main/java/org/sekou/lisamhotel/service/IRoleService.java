package org.sekou.lisamhotel.service;

import org.sekou.lisamhotel.model.Role;
import org.sekou.lisamhotel.model.User;

import java.util.List;

public interface IRoleService {
    List<Role> getRoles();

    void createRole(Role theRole);

    void deleteRole(Long roleId);

    Role removeAllUsersFromRole(Long roleId);

    User removeUserFromRole(Long userId, Long roleId);

    User assignRoleToUser(Long userId, Long roleId);
}
