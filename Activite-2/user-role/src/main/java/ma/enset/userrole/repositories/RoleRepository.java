package ma.enset.userrole.repositories;
import ma.enset.userrole.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //component pour la couche DAO
public interface RoleRepository extends JpaRepository<Role,Long>{
 Role findByRoleName(String roleName);
}
