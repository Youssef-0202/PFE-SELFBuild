package org.example.chu_back_v0.Ws.dto.commun;


public class InfermierDto extends ProfilDto  {
    private Long id;
    private SexeDto sexeDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SexeDto getSexeDto() {
        return sexeDto;
    }

    public void setSexeDto(SexeDto sexeDto) {
        this.sexeDto = sexeDto;
    }
}
