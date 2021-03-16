package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Table;
import com.waitlist.information.system.waitlist.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Table")
public class TableRestController {
    @Autowired
    private TableRepository tableRepository;

    @PostMapping("/addTable")
    public Table addTable(@Valid @RequestBody Table table){
        return tableRepository.save(table);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    @GetMapping("/findAllTables")
    public List<Table> getTables(){
        return tableRepository.findAll();
    }

    @GetMapping("/findAllTables/{id}")
    public Optional<Table> getTableById(@PathVariable String id){
        Optional<Table> table = tableRepository.findById(id);
        if(!table.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return table;
    }

}
