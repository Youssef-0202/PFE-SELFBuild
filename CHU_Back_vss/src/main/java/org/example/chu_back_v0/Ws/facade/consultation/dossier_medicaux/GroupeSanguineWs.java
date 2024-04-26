package org.example.chu_back_v0.Ws.facade.consultation.dossier_medicaux;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.GroupSanguineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupeSanguine/")
@PreAuthorize("hasRole('Admin')")
public class GroupeSanguineWs {
    @Autowired
    GroupSanguineService groupSanguineService;

    @GetMapping("ref/{ref}")
    public GroupeSanguin findByRef(@PathVariable String ref) {
        return groupSanguineService.findByRef(ref);
    }
    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return groupSanguineService.deleteByRef( ref);
    }
    @GetMapping("")
    public List<GroupeSanguin> findAll() {
        return groupSanguineService.findAll();
    }
    @PostMapping("")
    public int save(@RequestBody  GroupeSanguin groupeSanguin) {
        return groupSanguineService.save(groupeSanguin);
    }
}
