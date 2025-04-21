package org.example.chu_back_v0.Ws.facade.patient;

import org.example.chu_back_v0.Ws.converter.patient.PatientConverter;
import org.example.chu_back_v0.Ws.dto.patient.PatientDto;
import org.example.chu_back_v0.bean.patient.Patient;
import org.example.chu_back_v0.service.facade.patient.PatientService;
import org.example.chu_back_v0.service.impl.patient.PatientServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient/")
public class PatientWs {
    @Autowired
    private PatientService patientService;

    @Autowired
    PatientConverter patientConverter;
    @GetMapping("numDossier/{numDossier}")
    public PatientDto findByNumDossier(@PathVariable String numDossier) {
        Patient patient = patientService.findByNumDossier(numDossier);
        PatientDto patientDto = patientConverter.toDto(patient);
        return patientDto;
    }

    @DeleteMapping("numDossier/{numDossier}")
    public int deleteByNumDossier(@PathVariable String numDossier) {
        return patientService.deleteByNumDossier(numDossier);
    }

    @GetMapping()
    public List<PatientDto> findAll() {
        List<Patient> all = patientService.findAll();
        return patientConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody PatientDto patientDto) {
        Patient patient = patientConverter.toBean(patientDto);
        return patientService.save(patient);
    }
}
