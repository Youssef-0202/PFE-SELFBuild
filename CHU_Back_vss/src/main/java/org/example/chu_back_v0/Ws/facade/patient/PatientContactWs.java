package org.example.chu_back_v0.Ws.facade.patient;

import org.example.chu_back_v0.Ws.converter.patient.PatientContactConverter;
import org.example.chu_back_v0.Ws.dto.patient.PatientContactDto;
import org.example.chu_back_v0.bean.patient.PatientContact;
import org.example.chu_back_v0.service.facade.patient.PatientContactService;
import org.example.chu_back_v0.service.impl.patient.PatientContactServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patientContact/")
@PreAuthorize("hasRole('Admin')")
public class PatientContactWs {
    @Autowired
    private PatientContactService patientContactService;
    @Autowired
    PatientContactConverter patientContactConverter;


    @GetMapping("ref/{ref}")
    public PatientContactDto findByCin(@PathVariable String cin) {
        PatientContact patientContact = patientContactService.findByCin(cin);
        PatientContactDto patientContactDto = patientContactConverter.toDto(patientContact);
        return patientContactDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByCin(@PathVariable String cin) {
        return patientContactService.deleteByCin(cin);
    }

    @GetMapping()
    public List<PatientContactDto> findAll() {
        List<PatientContact> all = patientContactService.findAll();
        return patientContactConverter.toDto(all);
    }

    @PostMapping("")
    public int save(@RequestBody PatientContactDto patientContactDto) {
        PatientContact patientContact = patientContactConverter.toBean(patientContactDto);
        return patientContactService.save(patientContact);
    }
}
