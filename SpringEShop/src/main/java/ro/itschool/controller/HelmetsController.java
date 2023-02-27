package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Helmets;
import ro.itschool.entity.User;
import ro.itschool.service.HelmetsService;

import java.util.List;

@RestController
@RequestMapping(path = "/helmets")
public class HelmetsController {

    @Autowired
    private HelmetsService helmetsService;

    @GetMapping(path = "/all")
    public List<Helmets> getUser(){
        return helmetsService.getHelmets();
    }

    @PostMapping(path = "/post")
    public void createHelmets(@RequestBody Helmets helmets){
        helmetsService.createHelmets(helmets);
    }

    @PutMapping(path = "/{id}" )
    public void updateHelmets(@PathVariable Integer id, @RequestBody Helmets helmets){
        helmetsService.updateHelmets(id, helmets);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHelmets(@PathVariable Integer id){
        helmetsService.deleteHelmets(id);
    }

}
