package org.example.chu_back_v0.Ws.facade.commun;

import org.example.chu_back_v0.Ws.converter.commun.SexeConverter;
import org.example.chu_back_v0.Ws.dto.commun.SexeDto;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.service.facade.commun.SexeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sexe/")
public class SexeWs {
    @Autowired
    private SexeService sexeService;
@Autowired
    private SexeConverter sexeConverter;

    @GetMapping("code/{ref}")
    public SexeDto findByRef(@PathVariable String ref) {
        Sexe sexe = sexeService.findByRef(ref);
        SexeDto sexeDto = sexeConverter.toDto(sexe);
        return  sexeDto;
    }
    @DeleteMapping("code/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return sexeService.deleteByRef(ref);
    }
    @GetMapping()
    public List<SexeDto> findAll() {
        List<Sexe> all = sexeService.findAll();
        return sexeConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody SexeDto sexeDto) {
        Sexe sexe = sexeConverter.toBean(sexeDto);
        return sexeService.save(sexe);
    }
    @DeleteMapping()

    @Transactional
    public void deleteAll() {
        sexeService.deleteAll();
    }



}
