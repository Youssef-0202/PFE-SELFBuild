package org.example.chu_back_v0.Ws.facade.commun;

import org.example.chu_back_v0.Ws.converter.commun.MedecinConverter;
import org.example.chu_back_v0.Ws.dto.commun.InfermierDto;
import org.example.chu_back_v0.Ws.dto.commun.MedecinDto;
import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.service.facade.commun.MedecinService;
import org.example.chu_back_v0.service.impl.commun.MedecinServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medecin/")
@PreAuthorize("hasRole('Admin')")
public class MedecinWs {
    @Autowired
    private MedecinConverter medecinConverter;
    @Autowired
     private  MedecinService medecinService;

    @GetMapping("ref/{ref}")
    public MedecinDto findByRef(@PathVariable String ref) {
        Medecin medecin = medecinService.findByRef(ref);
       MedecinDto medecinDto = medecinConverter.toDto(medecin);
        return  medecinDto ;
    }

    @DeleteMapping("ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {

        return medecinService.deleteByRef(ref);
    }

    @GetMapping()
    public List<MedecinDto> findAll() {
        List<Medecin> all = medecinService.findAll();

        return medecinConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody MedecinDto medecinDto)
    {
       Medecin medecin = medecinConverter.toBean(medecinDto);
        return medecinService.save(medecin);
    }
}

;

