package org.example.chu_back_v0.Ws.facade.commun;

import org.example.chu_back_v0.Ws.converter.commun.InfermierConverter;
import org.example.chu_back_v0.Ws.dto.commun.InfermierDto;
import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.service.facade.commun.InfermierService;
import org.example.chu_back_v0.service.impl.commun.InfermierServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/infermier/")
public class InfermierWs {

    @Autowired
    private InfermierService infermierService;
    @Autowired
    private  InfermierConverter infermierConverter;

    @GetMapping("ref/{ref}")
    public InfermierDto findByRef(@PathVariable String ref) {
        Infermier infermier = infermierService.findByRef(ref);
        InfermierDto infermierDto = infermierConverter.toDto(infermier);
        return infermierDto;
    }

    @DeleteMapping("ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return infermierService.deleteByRef(ref);
    }

    @GetMapping()
    public List<InfermierDto> findAll() {
        List<Infermier> all = infermierService.findAll();
        return infermierConverter.toDto(all);
    }


    @PostMapping()
    public int save(@RequestBody InfermierDto infermierDto) {
       Infermier infermier = infermierConverter.toBean(infermierDto);
        return infermierService.save(infermier);
    }
}
