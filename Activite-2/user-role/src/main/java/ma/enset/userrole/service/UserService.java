package ma.enset.userrole.service;

import ma.enset.userrole.entities.Role;
import ma.enset.userrole.entities.User;

public interface UserService {
User addNewUser(User user);
Role addNewRole(Role role);
User findUserByUserName(String username);
    Role findRoleByRoleName(String rolename);
    void addRoleToUser(String username,String rolename);
}
