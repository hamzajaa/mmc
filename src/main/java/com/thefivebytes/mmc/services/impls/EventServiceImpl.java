package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.dto.CategoryDTO;
import com.thefivebytes.mmc.dto.EventStatusDto;
import com.thefivebytes.mmc.dto.EventTypeDTO;
import com.thefivebytes.mmc.dto.EventVilleDTO;
import com.thefivebytes.mmc.entities.Event;
import com.thefivebytes.mmc.entities.EventStatus;
import com.thefivebytes.mmc.entities.EventType;
import com.thefivebytes.mmc.entities.EventVille;
import com.thefivebytes.mmc.repositories.EventRepository;
import com.thefivebytes.mmc.services.facade.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {

    private EventRepository eventRepository;
    private ICategoryService categoryService;
    private IEventVilleService eventVilleService;
    private IEventTypeService eventTypeService;
    private EventStatusFacade eventStatusService;

    public EventServiceImpl(EventRepository eventRepository, ICategoryService categoryService, IEventVilleService eventVilleService, IEventTypeService eventTypeService, EventStatusFacade eventStatusService) {
        this.eventRepository = eventRepository;
        this.categoryService = categoryService;
        this.eventVilleService = eventVilleService;
        this.eventTypeService = eventTypeService;
        this.eventStatusService = eventStatusService;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event save(Event event) {
        prepareSave(event);
        Event result = null;
        Optional<Event> foundedEvent = findById(event.getId());
        if (foundedEvent.isEmpty()) {
            result = eventRepository.save(event);
        }
        return result;
    }

    private void prepareSave(Event event) {
        findCategory(event);
        findEventVille(event);
        findEventType(event);
        findEventStatus(event);
    }

    private void findEventStatus(Event event) {
        Optional<EventStatusDto> foundedEventStatus = eventStatusService.findById(event.getEventStatus().getId());
        if (foundedEventStatus.isPresent()) {
            event.setEventStatus(event.getEventStatus());
        }
    }

    private void findEventType(Event event) {
        Optional<EventTypeDTO> foundedEventType = eventTypeService.findEventTypeById(event.getEventType().getId());
        if (foundedEventType.isPresent()) {
            event.setEventType(event.getEventType());
        }
    }

    private void findEventVille(Event event) {
        Optional<EventVilleDTO> foundedVille = eventVilleService.findEventVilleById(event.getEventVille().getId());
        if (foundedVille.isPresent()) {
            event.setEventVille(event.getEventVille());
        }
    }

    private void findCategory(Event event) {
        Optional<CategoryDTO> foundedCategory = categoryService.findCategoryById(event.getCategory().getId());
        if (foundedCategory.isPresent()) {
            event.setCategory(event.getCategory());
        }
    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
