package com.ouchin.WRM.waitingroom.entity;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.waitingroom.Embedded.VisitId;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.time.LocalTime;

@Entity
public class Visit {

    @EmbeddedId
    private VisitId id;

    @NotNull(message = "Arrival time is required")
    private LocalTime arrivalTime;

    private LocalTime startTime;
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    private Status status;

    private Byte priority;
    private Duration estimatedProcessingTime;

    @ManyToOne
    @MapsId("visitorId")  // Maps to visitorId in VisitId
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @MapsId("waitingRoomId")  // Maps to waitingRoomId in VisitId
    @JoinColumn(name = "waiting_room_id")
    private WaitingRoom waitingRoom;

}
