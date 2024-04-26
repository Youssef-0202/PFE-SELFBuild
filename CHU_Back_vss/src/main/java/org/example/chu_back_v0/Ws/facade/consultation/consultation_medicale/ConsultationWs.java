package org.example.chu_back_v0.Ws.facade.consultation.consultation_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation/")
@PreAuthorize("hasRole('Admin')")
public class ConsultationWs {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private ConsultationConverter consultationConverter;
    @GetMapping("ref/{ref}")
    public Consultation findByRef(@PathVariable String ref) {
        Consultation consultation = consultationService.findByRef(ref);
        return consultation;
    }
    @DeleteMapping("ref/{ref}")
    public int deleteByRef( @PathVariable String ref) {
        return consultationService.deleteByRef(ref);
    }
@GetMapping()
    public List<ConsultationDto> findAll() {
    List<Consultation> all = consultationService.findAll();
    return consultationConverter.toDto(all);
    }
@PostMapping()
    public int save(@RequestBody ConsultationDto consultationDto) {
        Consultation consultation = consultationConverter.toBean(consultationDto);
        return consultationService.save(consultation);
    }
}
