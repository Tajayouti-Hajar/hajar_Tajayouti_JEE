package ma.tajayouti.activiteetudiantmvcspring;

import ma.tajayouti.activiteetudiantmvcspring.entities.Gender;
import ma.tajayouti.activiteetudiantmvcspring.entities.Student;
import ma.tajayouti.activiteetudiantmvcspring.repositories.StudentRepository;
import ma.tajayouti.activiteetudiantmvcspring.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ActiviteEtudiantMvcSPringApplication {

    public static void main(String[] args) {

        SpringApplication.run(ActiviteEtudiantMvcSPringApplication.class, args);
    }

    @Bean
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

  //  @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student(null,"hajar","tajayouti","tajayoutihajar@gmail.com",new Date(), Gender.Feminin,true));

            studentRepository.save(new Student(null,"hajar","tajayouti","tajayoutihajar@gmail.com",new Date(), Gender.Feminin,true));
            studentRepository.save(new Student(null,"hajar","tajayouti","tajayoutihajar@gmail.com",new Date(), Gender.Feminin,true));
            studentRepository.save(new Student(null,"hajar","tajayouti","tajayoutihajar@gmail.com",new Date(), Gender.Feminin,true));

            studentRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("hajar","1234","1234");
            securityService.saveNewUser("sara","1234","1234");
            securityService.saveNewUser("ahmed","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("hajar","USER");
            securityService.addRoleToUser("hajar","ADMIN");
            securityService.addRoleToUser("sara","USER");
            securityService.addRoleToUser("ahmed","USER");


        };
    }
}
