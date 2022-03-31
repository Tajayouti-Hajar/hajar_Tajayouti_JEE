package ma.enset.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date DAteConsult;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;
    //(mappedBy = "consultation") //cle etrangere "consultation" sur RendezVous
    /*qu est ce qu on va creer en premier lieu
     * ici c rdv , donc dand je veux creer une consultation je vais l afecter a un rdv donc cle etranger rdv
     * sur consultation*/

}
