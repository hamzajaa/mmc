package com.thefivebytes.mmc.services.facade;

import com.thefivebytes.mmc.dto.EventVilleDTO;
import com.thefivebytes.mmc.entities.EventVille;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IEventVilleService {
    Optional<EventVilleDTO> findEventVilleById(Long id);

    Optional<List<EventVilleDTO>> findAllEventVilles();

    Optional<EventVilleDTO> addEventVille(EventVilleDTO eventVilleDTO);

    Optional<EventVilleDTO> updateEventVille(EventVilleDTO eventVilleDTO);

    void deleteEventVille(Long id);

}
