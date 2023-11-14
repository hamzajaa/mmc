package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.services.impls.eventStatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.thefivebytes.mmc.dto.eventStatusDto;


import java.util.List;

@RestController
@RequestMapping("/eventStatus")
public class eventStatusControllers {
    @Autowired
    private  eventStatusImpl eventStatusImp;


    @GetMapping("/{id}")
    public eventStatusDto findeventStatusById(@PathVariable Long id) {
        return eventStatusImp.findById(id).orElseThrow();
    }

    @GetMapping
    public List<eventStatusDto> findAlleventStatus() {
        return eventStatusImp.findAllStatus().orElseThrow() ;
    }

    @PostMapping
    public eventStatusDto addeventStatus(@RequestBody eventStatusDto p) {

        return eventStatusImp.addStatus(p).orElseThrow() ;
    }

    @PutMapping
    public eventStatusDto updateeventStatus(@RequestBody eventStatusDto p) {
        return eventStatusImp.updateStatus(p).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteeventStatus(@PathVariable Long id){

        eventStatusImp.deleteStatus(id);
    }


}