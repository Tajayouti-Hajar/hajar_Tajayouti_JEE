package ma.tajayouti.activiteetudiantmvcspring.security.repositories;


import ma.tajayouti.activiteetudiantmvcspring.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
