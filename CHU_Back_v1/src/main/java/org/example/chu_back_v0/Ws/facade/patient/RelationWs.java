package org.example.chu_back_v0.Ws.facade.patient;

import org.example.chu_back_v0.Ws.converter.patient.RelationConverter;
import org.example.chu_back_v0.Ws.dto.patient.RelationDto;
import org.example.chu_back_v0.bean.patient.Relation;
import org.example.chu_back_v0.service.facade.patient.RelationService;
import org.example.chu_back_v0.service.impl.patient.RelationServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relation/")
public class RelationWs {
    @Autowired
    private RelationService relationService;
    @Autowired
    RelationConverter relationConverter;

    @GetMapping("ref/{ref}")
    public RelationDto findByRef(@PathVariable String ref) {
        Relation relation = relationService.findByRef(ref);
        RelationDto relationDto = relationConverter.toDto(relation);
        return  relationDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return relationService.deleteByRef(ref);
    }

    @GetMapping()
    public List<RelationDto> findAll() {
        List<Relation> all = relationService.findAll();
        return relationConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody RelationDto relationDto) {
        Relation relation = relationConverter.toBean(relationDto);
        return relationService.save(relation);
    }
}
