package com.ouchin.WRM.waitingroom.service;

import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitService{
        List<VisitResponseDto> findAll();
        VisitResponseDto subscribeVisitor(VisitRequestDto dto);
        void cancelSubscription(Long visitId);
        VisitResponseDto beginVisit(Long visitId);
        VisitResponseDto completeVisit(Long visitId);

}
