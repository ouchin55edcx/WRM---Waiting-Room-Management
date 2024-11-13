package com.ouchin.WRM.waitingroom.service;

import java.util.List;

import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;

public interface VisitService{

        List<VisitResponseDto> findAll();
        VisitResponseDto findById(Integer id);
        VisitResponseDto subscribeVisitor(VisitRequestDto dto);
        void cancelSubscription(Integer id);
        VisitResponseDto beginVisit(Integer id);
    
        VisitResponseDto completeVisit(Integer id);

        void delete(Integer id);

    
}
