package org.example.chu_back_v0.Ws.facade.convention.dossier_medicaux;

import org.example.chu_back_v0.Ws.converter.consultation.dossier_medical.EpreuveConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.EpreuveDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epreuve/")
public class EpreuveWS {
    @Autowired
    private EpreuveService epreuveService;
    @Autowired
    private EpreuveConverter epreuveConverter;

    @GetMapping("ref/{ref}")
    public EpreuveDto findByRef(@PathVariable String ref) {
        Epreuve epreuve = epreuveService.findByRef(ref);
        EpreuveDto epreuveDto = epreuveConverter.toDto(epreuve);
        return epreuveDto;
    }

    @DeleteMapping("code/{coed}")
    public int deleteByRef(@PathVariable String ref) {
        return epreuveService.deleteByRef(ref);
    }

    @GetMapping()
    public List<EpreuveDto> findAll() {
        List<Epreuve> all = epreuveService.findAll();
        return epreuveConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody EpreuveDto epreuveDto) {
            Epreuve epreuve = epreuveConverter.toBean(epreuveDto);
            return epreuveService.save(epreuve);
        }
    }

