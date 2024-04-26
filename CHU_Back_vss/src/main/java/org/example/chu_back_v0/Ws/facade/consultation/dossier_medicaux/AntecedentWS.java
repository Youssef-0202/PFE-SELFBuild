package org.example.chu_back_v0.Ws.facade.consultation.dossier_medicaux;

import org.example.chu_back_v0.Ws.converter.consultation.dossier_medical.AntecedentConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.AntecedentDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.AntecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedent")
public class AntecedentWS {
    @Autowired
   private AntecedentService antecedentService;
    @Autowired
   private AntecedentConverter antecedentConverter;

    @GetMapping("ref/{ref}")
    public AntecedentDto findByRef(@PathVariable String ref) {
        Antecedent antecedent = antecedentService.findByRef(ref);
        AntecedentDto antecedentDto = antecedentConverter.toDto(antecedent);
        return antecedentDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return antecedentService.deleteByRef(ref);
    }

    @GetMapping()
    public List<AntecedentDto> findAll() {
        List<Antecedent> all = antecedentService.findAll();
        return antecedentConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody AntecedentDto antecedentDto) {
        Antecedent antecedent = antecedentConverter.toBean(antecedentDto);
        return antecedentService.save(antecedent);
}}
