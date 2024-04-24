package org.example.chu_back_v0.Ws.facade.convention.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale.CertificatConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.CertificatDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.CertificatServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificat/")
public class Certificatws {
    @Autowired
    private CertificatServive certificatService;

    @Autowired
   private CertificatConverter certificatConverter;

    @GetMapping("ref/{ref}")
    public CertificatDto findByRef(@PathVariable String ref) {
        Certificat certificat = certificatService.findByRef(ref);
        CertificatDto certificatDto = certificatConverter.toDto(certificat);
        return certificatDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return certificatService.deleteByRef(ref);
    }

    @GetMapping()
    public List<CertificatDto> findAll() {
            List<Certificat> all = certificatService.findAll();
            return certificatConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody CertificatDto certificatDto) {
        Certificat certificat = certificatConverter.toBean(certificatDto);
        return certificatService.save(certificat);
    }
}
