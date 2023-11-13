package com.thefivebytes.mmc.services.impls;

import com.thefivebytes.mmc.entities.SessionType;
import com.thefivebytes.mmc.repositories.SessionTypeRepository;
import com.thefivebytes.mmc.services.facade.ISessionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionTypeService implements ISessionTypeService {

    @Autowired
    private SessionTypeRepository sessionTypeRepository;

    @Override
    public List<SessionType> findAll() {
        return sessionTypeRepository.findAll();
    }

    @Override
    public Optional<SessionType> findById(Long id) {
        return sessionTypeRepository.findById(id);
    }

    @Override
    public Optional<SessionType> findByLabel(String label) {
        return sessionTypeRepository.findByLabel(label);
    }

    @Override
    public SessionType save(SessionType sessionType) {
        SessionType result = null;
        Optional<SessionType> foundedSessionType = findByLabel(sessionType.getLabel());
        if (foundedSessionType.isEmpty()) {
            result = sessionTypeRepository.save(sessionType);
        }
        return result;
    }

    @Override
    public SessionType update(SessionType sessionType) {
        SessionType result = null;
        Optional<SessionType> foundedSessionType = findById(sessionType.getId());
        if (foundedSessionType.isPresent()) {
            result = sessionTypeRepository.save(sessionType);
        }
        return result;
    }

    @Override
    public int delete(Long id) {
        int res = 0;
        Optional<SessionType> foundedSessionType = findById(id);
        if (foundedSessionType.isPresent()) {
            sessionTypeRepository.deleteById(id);
            res = 1;
        }
        return res;
    }
}
