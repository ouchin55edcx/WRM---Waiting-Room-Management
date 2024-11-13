package com.ouchin.WRM.waitingroom.entity;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.waitingroom.Embedded.VisitId;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;

@Data
@NoArgsConstructor
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
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @MapsId("waitingRoomId")
    @JoinColumn(name = "waiting_room_id")
    private WaitingRoom waitingRoom;
}
