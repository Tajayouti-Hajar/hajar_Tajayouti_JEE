package ma.enset.etudiantmvc;

import ma.enset.etudiantmvc.entities.Etudiant;
import ma.enset.etudiantmvc.entities.Genre;
import ma.enset.etudiantmvc.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.GenerationType;
import java.util.Date;

@SpringBootApplication
public class EtudiantMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner start(EtudiantRepository etudiantRepository)
    {
        return args -> {
            etudiantRepository.save(new Etudiant(null,"tajayouti","hajar","email@gmail.com",new Date(), Genre.FEMININ,true));
            etudiantRepository.save(new Etudiant(null,"nassiri","Rim","email@gmail.com",new Date(), Genre.FEMININ,false));
            etudiantRepository.save(new Etudiant(null,"kilani","Ahmed","email@gmail.com",new Date(), Genre.MASCULIN,true));

            etudiantRepository.findAll().forEach(e->{
                System.out.println(e.getNom());
            });


        };
    }
}
