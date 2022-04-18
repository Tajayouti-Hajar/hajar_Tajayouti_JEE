package ma.tajayouti.activiteetudiantmvcspring.security.service;


import ma.tajayouti.activiteetudiantmvcspring.security.entities.AppRole;
import ma.tajayouti.activiteetudiantmvcspring.security.entities.AppUser;


public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePwd);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
