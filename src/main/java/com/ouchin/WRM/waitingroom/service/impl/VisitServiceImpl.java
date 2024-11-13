package com.ouchin.WRM.waitingroom.service.impl;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import com.ouchin.WRM.waitingroom.Embedded.VisitId;
import com.ouchin.WRM.waitingroom.Embedded.WaitingRoomId;
import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.entity.Visit;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import com.ouchin.WRM.waitingroom.mapper.VisitMapper;
import com.ouchin.WRM.waitingroom.repository.VisitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouchin.WRM.visitor.service.VisitorService;
import com.ouchin.WRM.waitingroom.service.VisitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitorService visitorService;
    private final VisitMapper visitMapper;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository, VisitorService visitorService, VisitMapper visitMapper) {
        this.visitRepository = visitRepository;
        this.visitorService = visitorService;
        this.visitMapper = visitMapper;
    }

    @Override
    public List<VisitResponseDto> findAll() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDto findById(VisitorId visitorId, WaitingRoomId waitingRoomId) {
        VisitId visitId = new VisitId(visitorId, waitingRoomId);
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found for Visitor ID: " + visitorId + " and Waiting Room ID: " + waitingRoomId));
        return visitMapper.toDto(visit);
    }

    @Override
    public VisitResponseDto subscribeVisitor(VisitRequestDto dto) {
        var visitor = visitorService.findEntityById(dto.getVisitorId());
        var visit = visitMapper.toEntity(dto);

        visit.setVisitor(visitor);
        visit.setId(new VisitId(dto.getVisitorId(), dto.getWaitingRoomId()));

        return visitMapper.toDto(visitRepository.save(visit));
    }


    @Override
    public void cancelSubscription(VisitorId visitorId, WaitingRoomId waitingRoomId) {
        VisitId visitId = new VisitId(visitorId, waitingRoomId);
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found for Visitor ID: " + visitorId + " and Waiting Room ID: " + waitingRoomId));
        visit.setStatus(Status.CANCELED);
        visitRepository.save(visit);
    }

    @Override
    public VisitResponseDto beginVisit(VisitorId visitorId, WaitingRoomId waitingRoomId) {
        VisitId visitId = new VisitId(visitorId, waitingRoomId);
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found for Visitor ID: " + visitorId + " and Waiting Room ID: " + waitingRoomId));
        visit.setStatus(Status.IN_PROGRESS);
        return visitMapper.toDto(visitRepository.save(visit));
    }

    @Override
    public VisitResponseDto completeVisit(VisitorId visitorId, WaitingRoomId waitingRoomId) {
        VisitId visitId = new VisitId(visitorId, waitingRoomId);
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found for Visitor ID: " + visitorId + " and Waiting Room ID: " + waitingRoomId));
        visit.setStatus(Status.FINISHED);
        return visitMapper.toDto(visitRepository.save(visit));
    }

    @Override
    public void delete(VisitorId visitorId, WaitingRoomId waitingRoomId) {
        VisitId visitId = new VisitId(visitorId, waitingRoomId);
        visitRepository.deleteById(visitId);
    }
}