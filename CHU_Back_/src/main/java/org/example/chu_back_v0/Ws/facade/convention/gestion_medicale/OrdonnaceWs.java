package org.example.chu_back_v0.Ws.facade.convention.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale.OrdonnanceConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.OrdonnanceDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordonnance/")
public class OrdonnaceWs {
    @Autowired
    private OrdonnanceService ordonnanceService;
    @Autowired
   private OrdonnanceConverter ordonnanceConverter;

    @GetMapping("ref/{ref}")
    public OrdonnanceDto findByRef(@PathVariable String ref) {
        Ordonnance ordonnance = ordonnanceService.findByRef(ref);
       OrdonnanceDto ordonnanceDto = ordonnanceConverter.toDto(ordonnance);
        return ordonnanceDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return ordonnanceService.deleteByRef(ref);
    }

    @GetMapping()
    public List<OrdonnanceDto> findAll() {
        List<Ordonnance> all = ordonnanceService.findAll();
        return ordonnanceConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody OrdonnanceDto ordonnanceDto) {
        Ordonnance ordonnance = ordonnanceConverter.toBean(ordonnanceDto);
        return ordonnanceService.save(ordonnance);
    }
}
