package com.ouchin.WRM.waitingroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouchin.WRM.visitor.service.VisitorService;
import com.ouchin.WRM.waitingroom.service.VisitService;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitService visitRepository;
    private final VisitorService visitorService;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository, VisitorService visitorService) {
        this.visitRepository = visitRepository;
        this.visitorService = visitorService;
    }

    @Override
    public List<VisitResponseDto> findAll() {
        return visitRepository.findAll().stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDto findById(Integer id) {
        return visitRepository.findById(id)
            .map(this::convertToResponseDto)
            .orElseThrow(() -> new EntityNotFoundException("Visit not found for ID: " + id));
    }

    @Override
    public VisitResponseDto subscribeVisitor(VisitRequestDto dto) {
        // Logic to subscribe a visitor
        var visitor = visitorService.findEntityById(dto.getVisitorId());
        var visit = new Visit();
        visit.setVisitor(visitor);
        // additional logic for setting visit properties
        return convertToResponseDto(visitRepository.save(visit));
    }

    @Override
    public void cancelSubscription(Integer id) {
        Visit visit = visitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Visit not found for ID: " + id));
        visit.setCancelled(true);  // Assuming there’s a field to indicate cancellation
        visitRepository.save(visit);
    }

    @Override
    public VisitResponseDto beginVisit(Integer id) {
        Visit visit = visitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Visit not found for ID: " + id));
        visit.setStatus("In Progress");  // Assuming there’s a status field
        return convertToResponseDto(visitRepository.save(visit));
    }

    @Override
    public VisitResponseDto completeVisit(Integer id) {
        Visit visit = visitRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Visit not found for ID: " + id));
        visit.setStatus("Completed");  // Assuming there’s a status field
        return convertToResponseDto(visitRepository.save(visit));
    }

    @Override
    public void delete(Integer id) {
        visitRepository.deleteById(id);
    }

}