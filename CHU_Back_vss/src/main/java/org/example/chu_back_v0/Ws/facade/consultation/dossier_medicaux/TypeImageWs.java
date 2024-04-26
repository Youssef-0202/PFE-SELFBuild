package org.example.chu_back_v0.Ws.facade.consultation.dossier_medicaux;

import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.TypeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeImage/")
@PreAuthorize("hasRole('Admin')")
public class TypeImageWs {
    @Autowired
    TypeImageService typeImageService;
    @GetMapping("ref/{ref}")
    public TypeImage findByRef(@PathVariable String ref) {
        return typeImageService.findByRef(ref);
    }
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return typeImageService.deleteByRef(ref);
    }
    @GetMapping()
    public List<TypeImage> findAll() {
        return typeImageService.findAll();
    }
    @PostMapping("")
    public int save(@RequestBody TypeImage typeImage) {
        return typeImageService.save(typeImage);
    }
}
