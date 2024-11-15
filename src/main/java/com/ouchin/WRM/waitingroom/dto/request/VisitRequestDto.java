package com.ouchin.WRM.waitingroom.dto.request;

import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VisitRequestDto {
    @NotNull(message = "Arrival time is required")
    private String arrivalTime;

    private Byte priority;

    @NotNull(message = "Visitor ID is required")
    private Long visitorId;

    private Long waitingRoomId;

    private Status status;

    public Long getVisitorId() {
        return visitorId;
    }



}
