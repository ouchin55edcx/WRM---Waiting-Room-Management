package com.ouchin.WRM.waitingroom.service.impl;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.visitor.repository.VisitorRepository;
import com.ouchin.WRM.visitor.service.VisitorService;
import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.entity.Visit;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import com.ouchin.WRM.waitingroom.mapper.VisitMapper;
import com.ouchin.WRM.waitingroom.repository.VisitRepository;
import com.ouchin.WRM.waitingroom.service.VisitService;
import com.ouchin.WRM.waitingroom.service.WaitingRoomService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    VisitorRepository visitorRepository;

    public VisitServiceImpl(VisitRepository visitRepository, VisitMapper visitMapper) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
    }

    @Override
    public List<VisitResponseDto> findAll() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDto subscribeVisitor(VisitRequestDto dto) {
        Visit visit = new Visit();
        Visitor visitor = visitorRepository.findById(dto.getVisitorId()) // Lombok should generate getVisitorId() method
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with ID: " + dto.getVisitorId()));

        visit.setStatus(Status.WAITING);
        return visitMapper.toResponseDto(visitRepository.save(visit));
    }



    @Override
    public void cancelSubscription(Long visitId) {
        Visit visit = findVisitAndValidateStatus(visitId, Status.WAITING, "Cannot cancel a visit that is not in WAITING status");
        visitRepository.delete(visit);
    }

    @Override
    public VisitResponseDto beginVisit(Long visitId) {
        Visit visit = findVisitAndValidateStatus(visitId, Status.WAITING, "Visit must be in WAITING status to begin");

        visit.setStatus(Status.IN_PROGRESS);

        return visitMapper.toResponseDto(visitRepository.save(visit));
    }

    @Override
    public VisitResponseDto completeVisit(Long visitId) {
        Visit visit = findVisitAndValidateStatus(visitId, Status.IN_PROGRESS, "Visit must be in IN_PROGRESS status to complete");

        visit.setStatus(Status.FINISHED);

        return visitMapper.toResponseDto(visitRepository.save(visit));
    }

    private Visit findVisitAndValidateStatus(Long visitId, Status expectedStatus, String errorMessage) {
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found with id: " + visitId));

        if (visit.getStatus() != expectedStatus) {
            throw new IllegalStateException(errorMessage);
        }

        return visit;
    }
}