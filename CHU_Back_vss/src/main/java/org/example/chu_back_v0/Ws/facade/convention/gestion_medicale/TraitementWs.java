package org.example.chu_back_v0.Ws.facade.convention.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale.TraitementConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.TraitementDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.TraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traitement/")
public class TraitementWs {
    @Autowired
  private   TraitementService traitementService;
    @Autowired
     private TraitementConverter traitementConverter;

    @GetMapping("ref/{ref}")
    public TraitementDto findByRef(@PathVariable String ref) {
        Traitement traitement = traitementService.findByRef(ref);
        TraitementDto traitementDto = traitementConverter.toDto(traitement);
        return  traitementDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return traitementService.deleteByRef(ref);
    }

    @GetMapping()
    public List<TraitementDto> findAll() {
        List<Traitement> all = traitementService.findAll();
        return traitementConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody TraitementDto traitementDto) {
        Traitement traitement = traitementConverter.toBean(traitementDto);
        return traitementService.save(traitement);
    }
}
