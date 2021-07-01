package br.com.grupo3.calculadoracasa.controller;

import br.com.grupo3.calculadoracasa.controller.dto.CasaDto;
import br.com.grupo3.calculadoracasa.controller.dto.ComodoDto;
import br.com.grupo3.calculadoracasa.controller.form.casaForm.CasaForm;
import br.com.grupo3.calculadoracasa.controller.form.casaForm.ComodoForm;
import br.com.grupo3.calculadoracasa.modelo.Casa;
import br.com.grupo3.calculadoracasa.modelo.Comodo;
import br.com.grupo3.calculadoracasa.repository.CasaRepository;
import br.com.grupo3.calculadoracasa.repository.ComodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaRepository casaRepository;
    private final ComodoRepository comodoRepository;

    public CasaController(CasaRepository casaRepository, ComodoRepository comodoRepository) {
        this.casaRepository = casaRepository;
        this.comodoRepository = comodoRepository;
    }

    @GetMapping
    public List<CasaDto> lista(){
        List<Casa> casas = casaRepository.findAll();
        return CasaDto.converter(casas);
    }

    @GetMapping("/comodos")
    public List<ComodoDto> listaComodos(){
        List<Comodo> comodos = comodoRepository.findAll();
        return ComodoDto.converter(comodos);
    }

    @Transactional
    @PostMapping()
    public ResponseEntity<CasaDto> criarCasa(@RequestBody @Valid CasaForm form, UriComponentsBuilder uriBuilder){
        Casa casa = form.converter();
        casaRepository.save(casa);

        URI uri = uriBuilder.path("/casa/{id}").buildAndExpand(casa.getId()).toUri();
        return ResponseEntity.created(uri).body(new CasaDto(casa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaDto> casa(@PathVariable Long id){
        Optional<Casa> optionalCasa = casaRepository.findById(id);
        if (optionalCasa.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new CasaDto(optionalCasa.get()));
    }

    @GetMapping("/comodo/{id}")
    public ResponseEntity<ComodoDto> comodo(@PathVariable Long id){
        Optional<Comodo> optionalComodo = comodoRepository.findById(id);
        if (optionalComodo.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new ComodoDto(optionalComodo.get()));
    }

    @Transactional
    @PostMapping("/{id}/comodo")
    public ResponseEntity<ComodoDto> adicionaComodo(
            @RequestBody @Valid ComodoForm form, UriComponentsBuilder uriBuilder,
            @PathVariable Long id){

        Optional<Casa> casaOptional = casaRepository.findById(id);

        if(casaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Comodo comodo = form.converter(casaOptional.get());
        comodoRepository.save(comodo);
        casaOptional.get().atualiza();

        URI uri = uriBuilder.path("/casa/comodo/{id}").buildAndExpand(comodo.getId()).toUri();
        return ResponseEntity.created(uri).body(new ComodoDto(comodo));
    }





}
