package com.ouchin.WRM.waitingroom.service;

import java.util.List;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import com.ouchin.WRM.waitingroom.Embedded.WaitingRoomId;
import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;

public interface VisitService{
        List<VisitResponseDto> findAll();
        VisitResponseDto findById(VisitorId visitorId, WaitingRoomId waitingRoomId);
        VisitResponseDto subscribeVisitor(VisitRequestDto dto);
        void cancelSubscription(VisitorId visitorId, WaitingRoomId waitingRoomId);
        VisitResponseDto beginVisit(VisitorId visitorId, WaitingRoomId waitingRoomId);
        VisitResponseDto completeVisit(VisitorId visitorId, WaitingRoomId waitingRoomId);
        void delete(VisitorId visitorId, WaitingRoomId waitingRoomId);

}
