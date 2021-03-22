package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Table;
import com.waitlist.information.system.waitlist.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;


@RestController
@RequestMapping("/Table")
public class TableRestController {
    @Autowired
    private TableRepository tableRepository;

    @PostMapping("/addTable")
    public Table addTable(@Valid @RequestBody Table table){
        return tableRepository.save(table);
    }

    /**
     * Gets the errors when posting a invalid table.
     * @param ex gives not valid exception
     * @return handle method exception
     * @throws Exception when user input is invalid
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    /**
     *Gets all tables by id.
     * @return all tables
     */
    @GetMapping("/findAllTables")
    public List<Table> getTables(){
        return tableRepository.findAll();
    }

    /**
     *Gets tables by id.
     * @param id is the tables id
     * @return tables
     */
    @GetMapping("/findAllTables/{id}")
    public Optional<Table> getTableById(@PathVariable String id){
        Optional<Table> table = tableRepository.findById(id);
        if(!table.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return table;
    }

}
