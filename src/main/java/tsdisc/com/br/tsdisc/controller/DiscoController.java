package tsdisc.com.br.tsdisc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tsdisc.com.br.tsdisc.domain.Disco;
import tsdisc.com.br.tsdisc.service.DiscoService;

import java.util.List;

@RestController
@RequestMapping("discos")
public class DiscoController {
    private final DiscoService discoService;

    public DiscoController(DiscoService discoService){
        this.discoService = discoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Disco> findAll(){
        return discoService.listAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Disco findById(@PathVariable long id){
        return discoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disco save(@RequestBody Disco disco){
        return discoService.save(disco);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Disco delete(@PathVariable long id){
        discoService.delete(id);
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Disco replace(@RequestBody Disco disco){
        discoService.replace(disco);
        return null;
    }
}
