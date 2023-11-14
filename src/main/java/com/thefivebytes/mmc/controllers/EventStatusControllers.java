package com.thefivebytes.mmc.controllers;


import com.thefivebytes.mmc.dto.EventStatusDto;
import com.thefivebytes.mmc.services.impls.EventStatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/eventStatus")
public class EventStatusControllers {
    @Autowired
    private EventStatusImpl eventStatusImp;


    @GetMapping("/{id}")
    public EventStatusDto findeventStatusById(@PathVariable Long id) {
        return eventStatusImp.findById(id).orElseThrow();
    }

    @GetMapping
    public List<EventStatusDto> findAlleventStatus() {
        return eventStatusImp.findAllStatus().orElseThrow() ;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventStatusDto addeventStatus(@RequestBody EventStatusDto p) {

        return eventStatusImp.addStatus(p).orElseThrow() ;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public EventStatusDto updateeventStatus(@RequestBody EventStatusDto p) {
        return eventStatusImp.updateStatus(p).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteeventStatus(@PathVariable Long id){

        eventStatusImp.deleteStatus(id);
    }


}
