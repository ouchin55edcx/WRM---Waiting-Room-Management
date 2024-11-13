package com.ouchin.WRM.visitor.service.impl;

import org.springframework.stereotype.Service;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import com.ouchin.WRM.visitor.service.VisitorService;
import com.ouchin.WRM.waitingroom.service.VisitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;


    @Override
    public Visitor findEntityById(Long id){
        return visitorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Visitor not found for ID: " + id))
    }



    
}
