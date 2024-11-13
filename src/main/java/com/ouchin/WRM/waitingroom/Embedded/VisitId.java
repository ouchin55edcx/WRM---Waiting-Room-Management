package com.ouchin.WRM.waitingroom.Embedded;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitId {
    private VisitorId visitorId;
    private WaitingRoomId waitingRoomId;


}