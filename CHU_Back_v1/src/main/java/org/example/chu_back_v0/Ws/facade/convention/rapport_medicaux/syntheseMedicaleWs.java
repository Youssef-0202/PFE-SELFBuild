package org.example.chu_back_v0.Ws.facade.convention.rapport_medicaux;

import org.example.chu_back_v0.Ws.converter.consultation.rapport_medicaux.SyntheseMedicaleConverter;
import org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux.syntheseMedicaleDto;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.SyntheseMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/syntheseMedicale/")
public class syntheseMedicaleWs {
    @Autowired
     private SyntheseMedicaleService syntheseMedicaleService;
    @Autowired
    private SyntheseMedicaleConverter syntheseMedicaleConverter;

    @GetMapping("ref/{ref}")
    public syntheseMedicaleDto findByRef(@PathVariable String ref) {
        SyntheseMedicale syntheseMedicale = syntheseMedicaleService.findByRef(ref);
        syntheseMedicaleDto syntheseMedicaleDto = syntheseMedicaleConverter.toDto(syntheseMedicale);
        return syntheseMedicaleDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return syntheseMedicaleService.deleteByRef(ref);
    }

    @GetMapping
    public List<syntheseMedicaleDto> findAll() {
        List<SyntheseMedicale> all =syntheseMedicaleService.findAll();
        return syntheseMedicaleConverter.toDto(all);
    }




    @PostMapping()
    public int save(@RequestBody syntheseMedicaleDto syntheseMedicaleDto) {
       SyntheseMedicale syntheseMedicale = syntheseMedicaleConverter.toBean(syntheseMedicaleDto);
        return syntheseMedicaleService.save(syntheseMedicale);
    }
}


