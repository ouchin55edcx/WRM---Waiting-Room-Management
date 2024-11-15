package com.ouchin.WRM.waitingroom.dto.response;

import com.ouchin.WRM.waitingroom.entity.enums.Status;
import lombok.Data;

@Data
public class VisitResponseDto {
    private Long id;
    private String arrivalTime;
    private String startTime;
    private String endTime;
    private Byte priority;
    private Status status;
    private Long visitorId;
    private String visitorFullName;
    private Long waitingRoomId;
}
