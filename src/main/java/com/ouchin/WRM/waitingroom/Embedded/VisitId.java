package com.ouchin.WRM.waitingroom.Embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitId {
    private Long visitorId;
    private Long waitingRoomId;
}