package org.example.chu_back_v0.Ws.facade.convention.rapport_medicaux;

import org.example.chu_back_v0.Ws.converter.consultation.rapport_medicaux.DiagnosticConverter;
import org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux.DiagnosticDto;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.Diagnostic;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/diagnostic/")
public class DiagnosticWS {
    @Autowired
   private DiagnosticService diagnosticService;
    @Autowired
    private DiagnosticConverter diagnosticConverter;

    @GetMapping("ref/{ref}")
    public DiagnosticDto findByRef(@PathVariable String ref) {
        Diagnostic diagnostic = diagnosticService.findByRef(ref);
        DiagnosticDto diagnosticDto = diagnosticConverter.toDto(diagnostic);
        return  diagnosticDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return diagnosticService.deleteByRef(ref);
    }

    @GetMapping()
    public List<DiagnosticDto> findAll() {
        List<Diagnostic> all = diagnosticService.findAll();
        return diagnosticConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody DiagnosticDto diagnosticDto) {
       Diagnostic diagnostic = diagnosticConverter.toBean(diagnosticDto);
        return diagnosticService.save(diagnostic);
    }


}
