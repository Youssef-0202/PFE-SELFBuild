package org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale;


import org.example.chu_back_v0.Ws.dto.commun.InfermierDto;
import org.example.chu_back_v0.Ws.dto.commun.MedecinDto;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.CertificatDto;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.OrdonnanceDto;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.TraitementDto;
import org.example.chu_back_v0.Ws.dto.patient.PatientDto;
import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.patient.Patient;

import javax.persistence.ManyToOne;
import java.util.Date;


public class ConsultationDto {
    private Long id;
    private String ref;
    private String avisMedicale;
    private Date dateConsultation;
    private Date heureConsultation;
    private String typeConsultation;
    private MedecinDto medecinDto;
    private InfermierDto infermierDto;
    private PatientDto patientDto;

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

    public String getAvisMedicale() {
        return avisMedicale;
    }

    public void setAvisMedicale(String avisMedicale) {
        this.avisMedicale = avisMedicale;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Date getHeureConsultation() {
        return heureConsultation;
    }

    public void setHeureConsultation(Date heureConsultation) {
        this.heureConsultation = heureConsultation;
    }

    public String getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(String typeConsultation) {
        this.typeConsultation = typeConsultation;
    }

    public MedecinDto getMedecinDto() {
        return medecinDto;
    }

    public void setMedecinDto(MedecinDto medecinDto) {
        this.medecinDto = medecinDto;
    }

    public InfermierDto getInfermierDto() {
        return infermierDto;
    }

    public void setInfermierDto(InfermierDto infermierDto) {
        this.infermierDto = infermierDto;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }
}
