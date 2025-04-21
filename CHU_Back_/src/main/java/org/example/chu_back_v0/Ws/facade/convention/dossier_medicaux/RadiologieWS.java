package org.example.chu_back_v0.Ws.facade.convention.dossier_medicaux;


import org.example.chu_back_v0.Ws.converter.consultation.dossier_medical.RadiologieConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.RadiologieDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Radiologie;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.RadiologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/radiologie/")
public class RadiologieWS {
    @Autowired
   private RadiologieService radiologieService;
    @Autowired
    private RadiologieConverter radiologieConverter;

    @GetMapping("ref/{ref}")
    public RadiologieDto findByRef(@PathVariable String ref) {
        Radiologie radiologie = radiologieService.findByRef(ref);
        RadiologieDto radiologieDto = radiologieConverter.toDto(radiologie);
        return radiologieDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return radiologieService.deleteByRef(ref);
    }

    @GetMapping()
    public List<RadiologieDto> findAll() {
            List<Radiologie> all = radiologieService.findAll();
            return radiologieConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody RadiologieDto radiologieDto) {

        Radiologie radiologie = radiologieConverter.toBean(radiologieDto);
        return radiologieService.save(radiologie);
    }
}
