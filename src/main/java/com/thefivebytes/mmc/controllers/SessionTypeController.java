package com.thefivebytes.mmc.controllers;

import com.thefivebytes.mmc.converters.SessionTypeConverter;
import com.thefivebytes.mmc.dto.SessionTypeDto;
import com.thefivebytes.mmc.entities.SessionType;
import com.thefivebytes.mmc.services.facade.ISessionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessionTypes")
//@CrossOrigin("*")
public class SessionTypeController {

    @Autowired
    private ISessionTypeService sessionTypeService;

    @Autowired
    SessionTypeConverter sessionTypeConverter;
    @GetMapping("/")
    public List<SessionType> findAll() {
        return sessionTypeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<SessionType> findById(@PathVariable Long id) {
        return sessionTypeService.findById(id);
    }

    @GetMapping("/label/{label}")
    public Optional<SessionType> findByLabel(@PathVariable String label) {
        return sessionTypeService.findByLabel(label);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/")
    public SessionTypeDto save(@RequestBody SessionTypeDto sessionTypeDto) {
        SessionType sessionType = sessionTypeConverter.toEntity(sessionTypeDto);
        sessionType = sessionTypeService.save(sessionType);
        return sessionTypeConverter.toDto(sessionType);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/")
    public SessionTypeDto update(@RequestBody SessionTypeDto sessionTypeDto) {
        SessionType sessionType = sessionTypeConverter.toEntity(sessionTypeDto);
        sessionType = sessionTypeService.update(sessionType);
        return sessionTypeConverter.toDto(sessionType);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return sessionTypeService.delete(id);
    }
}
