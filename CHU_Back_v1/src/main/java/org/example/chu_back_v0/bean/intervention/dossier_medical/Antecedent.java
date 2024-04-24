package org.example.chu_back_v0.bean.intervention.dossier_medical;


import javax.persistence.*;

@Entity
public class Antecedent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String allergie;
    private String etatPsy;
    private String respiration;
    private String mouvement;
    private String alimentation;
    private String sommeil;

    @ManyToOne
    private GroupeSanguin groupeSanguin;

    public String getSommeil() {
        return sommeil;
    }

    public void setSommeil(String sommeil) {
        this.sommeil = sommeil;
    }



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getEtatPsy() {
        return etatPsy;
    }

    public void setEtatPsy(String etatPsy) {
        this.etatPsy = etatPsy;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public String getMouvement() {
        return mouvement;
    }

    public void setMouvement(String mouvement) {
        this.mouvement = mouvement;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(String alimentation) {
        this.alimentation = alimentation;
    }

    public GroupeSanguin getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(GroupeSanguin groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
