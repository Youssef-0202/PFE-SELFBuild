package org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale;

import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class TraitementDto {
    private Long id;
    private String ref;
    private String imageOrdonnance;

    private List<MedicamentDto> MedicamentDtos;

    private ConsultationDto consultationDto;

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

    public String getImageOrdonnance() {
        return imageOrdonnance;
    }

    public void setImageOrdonnance(String imageOrdonnance) {
        this.imageOrdonnance = imageOrdonnance;
    }

    public List<MedicamentDto> getMedicamentDtos() {
        return MedicamentDtos;
    }

    public void setMedicamentDtos(List<MedicamentDto> medicamentDtos) {
        MedicamentDtos = medicamentDtos;
    }

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
