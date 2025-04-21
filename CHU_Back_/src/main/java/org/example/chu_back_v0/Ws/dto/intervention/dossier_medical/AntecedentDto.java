package org.example.chu_back_v0.Ws.dto.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;

public class AntecedentDto {
    private Long id;
    private String ref;
    private String allergie;
    private String etatPsy;
    private String respiration;
    private String mouvement;
    private String alimentation;
    private String sommeil;
    private GroupeSanguinDto groupeSanguinDto;

    public GroupeSanguinDto getGroupeSanguinDto() {
        return groupeSanguinDto;
    }

    public void setGroupeSanguinDto(GroupeSanguinDto groupeSanguinDto) {
        this.groupeSanguinDto = groupeSanguinDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSommeil() {
        return sommeil;
    }

    public void setSommeil(String sommeil) {
        this.sommeil = sommeil;
    }
}
