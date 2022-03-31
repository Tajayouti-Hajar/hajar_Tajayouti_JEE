package ma.enset.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity //entitie JPA
@Data //automatiquement lombok va ajouter les setter et les getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
    @OneToMany (mappedBy = "patient" ,fetch =FetchType.LAZY )
    private Collection<RendezVous> rdv;
    /*pour chaque passions nous vons plusieur rdv
     * id_patient sera representer comme cle etrangere cle sur rdv 1M
     * ,fetch = FetchType.LAZY
     * LAZY or EAGER
     * LAZY= ramene que les attribus de l'entite  / les donnes de la relation vont etre charge en cas de besoin
     * EAGER # LAZY  /relation forte */

}