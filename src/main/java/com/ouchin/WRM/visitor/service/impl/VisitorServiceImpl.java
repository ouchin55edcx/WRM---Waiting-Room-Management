package com.ouchin.WRM.visitor.service.impl;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import com.ouchin.WRM.visitor.service.VisitorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    @Override
    public Visitor findEntityById(VisitorId visitorId) {
        return visitorRepository.findById(visitorId)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found for ID: " + visitorId));
    }
}
