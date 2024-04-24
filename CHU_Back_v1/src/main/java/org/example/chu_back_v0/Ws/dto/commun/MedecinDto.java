package org.example.chu_back_v0.Ws.dto.commun;



public class MedecinDto  extends ProfilDto {
    private Long id;

    private String specialite;

    private SexeDto sexeDto;


    public Long getId() {
        return id;
    }

    public SexeDto getSexeDto() {
        return sexeDto;
    }

    public void setSexeDto(SexeDto sexeDto) {
        this.sexeDto = sexeDto;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

}

