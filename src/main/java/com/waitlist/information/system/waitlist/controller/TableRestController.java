package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Table;
import com.waitlist.information.system.waitlist.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Table")
public class TableRestController {
    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/findAllTables")
    public List<Table> getTables(){
        return tableRepository.findAll();
    }

    @GetMapping("/findAllTables/{id}")
    public Optional<Table> getTableById(@PathVariable int id){
        return tableRepository.findById(id);
    }

    @PostMapping("/addTable")
    public String addTable(@RequestBody Table table){
        tableRepository.save(table);
        return "Added table with id : " + table.getId();
    }
}
