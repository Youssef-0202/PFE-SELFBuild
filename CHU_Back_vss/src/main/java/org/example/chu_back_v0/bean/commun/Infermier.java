package org.example.chu_back_v0.bean.commun;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "infermier")
@DiscriminatorValue("infermier")
public class Infermier extends Profil {

    @ManyToOne
    private Sexe sexe;

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
}
