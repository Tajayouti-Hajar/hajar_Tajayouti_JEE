package ma.enset.userrole.service;

import lombok.AllArgsConstructor;
import ma.enset.userrole.entities.Role;
import ma.enset.userrole.entities.User;
import ma.enset.userrole.repositories.RoleRepository;
import ma.enset.userrole.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service  //compoent pour la couche metier
@Transactional
@AllArgsConstructor //injection via le const
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());//GENERE UN USER ID SOUS FORME DE CHAINE DE CHARKTERE
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {

        return userRepository.findByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String rolename) {

        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user=findUserByUserName(username);
        Role role=findRoleByRoleName(rolename);

        user.getRoles().add(role);
        role.getUsers().add(user);
        //userRepository.save(user);

  //aller ves la collection des roles de user et ajouter le role
    }
}
