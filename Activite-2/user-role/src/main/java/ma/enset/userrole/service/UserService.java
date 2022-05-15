package ma.enset.userrole.service;

import ma.enset.userrole.entities.Role;
import ma.enset.userrole.entities.User;

public interface UserService {
User addNewUser(User user); //creer un user
Role addNewRole(Role role); //ajouter un role
User findUserByUserName(String username); // chercher un user par son username
    Role findRoleByRoleName(String rolename); //chercher un role par le rolename
    void addRoleToUser(String username,String rolename); //associe un role a un user
}
