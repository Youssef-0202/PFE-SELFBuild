package org.example.chu_back_v0.bean.commun;


import javax.persistence.*;

@Entity
@Table(name = "medecin")
@DiscriminatorValue("medecin")
public class Medecin extends Profil {

    @ManyToOne
    private Sexe sexe;
    private String specialite;


    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }


}
