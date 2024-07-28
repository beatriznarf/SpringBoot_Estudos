package bsd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bsd.dtos.organizacaoDto;
import bsd.services.organizacaoService;
import bsd.dtos.organizacaoCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("organizacoes")
public class organizacaoController {

    private static final Logger logger = LoggerFactory.getLogger(organizacaoController.class);

    @Autowired
    private organizacaoService organizacaoService;


    @PostMapping
    public ResponseEntity<organizacaoDto> saveorganizacao(@RequestBody organizacaoCreateRequest organizacaoCreateRequest) {
        logger.info("Request organizacaoCreateRequest ");
        organizacaoDto savedorganizacao = organizacaoService.save(organizacaoCreateRequest);
        return new ResponseEntity<>(savedorganizacao, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrganizacao(@PathVariable Long id) {
        organizacaoService.delete(id);
    }



    @GetMapping
    public ResponseEntity<List<organizacaoDto>> listAllorganizacao() {
        List<organizacaoDto> organizacoes = organizacaoService.findAll();
        return new ResponseEntity<>(organizacoes, HttpStatus.OK);
    }




    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<organizacaoDto> getorganizacaoById(@PathVariable Long id) {
        organizacaoDto organizacaoDto = organizacaoService.findById(id);
        if (organizacaoDto != null) {
            return new ResponseEntity<>(organizacaoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<organizacaoDto> updateorganizacao(@PathVariable Long id, @RequestBody organizacaoDto organizacaoDetails) {
        organizacaoDto updatedorganizacao = organizacaoService.update(id, organizacaoDetails);
        if (updatedorganizacao != null) {
            return new ResponseEntity<>(updatedorganizacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

