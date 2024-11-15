package com.ouchin.WRM.visitor.service.impl;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import com.ouchin.WRM.visitor.service.VisitorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    @Override
    @Transactional(readOnly = true)
    public Visitor findEntityById(Long id) {
        log.debug("Finding visitor with id: {}", id);
        return visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found for ID: " + id));
    }
}
