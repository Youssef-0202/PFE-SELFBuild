package org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale;

import org.example.chu_back_v0.Ws.dto.commun.InfermierDto;

public class MedicamentDto {
    private Long id;
    private String ref;
    private String soinProduit;
    private String dure;
    private String consigne;

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

    public String getSoinProduit() {
        return soinProduit;
    }

    public void setSoinProduit(String soinProduit) {
        this.soinProduit = soinProduit;
    }

    public String getDure() {
        return dure;
    }

    public void setDure(String dure) {
        this.dure = dure;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }
}
