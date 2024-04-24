package org.example.chu_back_v0.Ws.facade.commun;

import org.example.chu_back_v0.bean.commun.Profil;
import org.example.chu_back_v0.service.facade.commun.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profil/")
public class ProfilWs {
    @Autowired
    private ProfilService profilService;
    @GetMapping("ref/{ref}")
    public Profil findByRef(@PathVariable String ref) {
        return profilService.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    @Transactional
    public int deleteByRef( @PathVariable  String ref) {
        return profilService.deleteByRef(ref);
    }
    @GetMapping()
    public List<Profil> findAll() {
        return profilService.findAll();
    }
    @PostMapping()
    public Profil save(@RequestBody Profil profil) {
        return profilService.save(profil);
    }
}
