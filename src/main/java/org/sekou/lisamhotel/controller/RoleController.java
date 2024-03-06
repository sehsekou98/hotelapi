package org.sekou.lisamhotel.controller;


import lombok.RequiredArgsConstructor;
import org.sekou.lisamhotel.exception.RoleAlreadyExistException;
import org.sekou.lisamhotel.model.Role;
import org.sekou.lisamhotel.model.User;
import org.sekou.lisamhotel.service.IBookingService;
import org.sekou.lisamhotel.service.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.FOUND;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService iRoleService;

    @GetMapping("/all-role")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(iRoleService.getRoles(), Found);
    }

    @PostMapping("/create-new-role")
    public ResponseEntity<String> createRole(@RequestBody Role theRole){
        try{
            iRoleService.createRole(theRole);
            return ResponseEntity.ok("Role created successfully");
        }catch(RoleAlreadyExistException re){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(re.getMessage());
        }
    }

    @DeleteMapping("/delete/{roleId}")
    public void deleteRole(@PathVariable ("roleId") Long roleId) {
        iRoleService.deleteRole(roleId);
    }

    @PostMapping("/remove-all-users-from-role/{roleId}")
    public Role removeAllUsersFromRole(@PathVariable("roleId") Long roleId){
        return iRoleService.removeAllUsersFromRole(roleId);
    }

    @PostMapping("/remove-user-from-role")
    public User removeUserFromRole(
            @RequestParam("userId") Long userId,
            @RequestParam("roleId") Long roleId){
        return iRoleService.removeUserFromRole(userId, roleId);
    }
    @PostMapping("/assign-user-to-role")
    public User assignUserToRole(
            @RequestParam("userId") Long userId,
            @RequestParam("roleId") Long roleId){
        return iRoleService.assignRoleToUser(userId, roleId);
    }
}
