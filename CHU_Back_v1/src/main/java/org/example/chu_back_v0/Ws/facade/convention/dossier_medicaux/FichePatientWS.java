package org.example.chu_back_v0.Ws.facade.convention.dossier_medicaux;

import org.example.chu_back_v0.Ws.converter.consultation.dossier_medical.FichePatientConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.FichePatientDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.FichePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichePatient/")
public class FichePatientWS {
    @Autowired
    private  FichePatientService fichePatientService;
    @Autowired
    private FichePatientConverter fichePatientConverter;

    @GetMapping("ref/{ref}")
    public FichePatientDto findByRef(@PathVariable String ref) {

        FichePatient fichePatient = fichePatientService.findByRef(ref);
        FichePatientDto fichePatientDto = fichePatientConverter.toDto(fichePatient);
        return fichePatientDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return fichePatientService.deleteByRef(ref);
    }

    @GetMapping()
    public List<FichePatientDto> findAll() {
        List<FichePatient> all = fichePatientService.findAll();
        return fichePatientConverter.toDto(all);

    }

    @PostMapping("")
    public int save(@RequestBody FichePatientDto fichePatientDto) {
            FichePatient fichePatient = fichePatientConverter.toBean(fichePatientDto);
            return fichePatientService.save(fichePatient);
        }

    }



