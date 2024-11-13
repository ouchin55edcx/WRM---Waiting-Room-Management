package com.ouchin.WRM.waitingroom.controller;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import com.ouchin.WRM.waitingroom.Embedded.WaitingRoomId;
import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.service.VisitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @Operation(summary = "Get all visits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved list of all visits",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisitResponseDto.class)))
    })
    @GetMapping
    public List<VisitResponseDto> getAllVisits() {
        return visitService.findAll();
    }

    @Operation(summary = "Get a visit by visitor ID and waiting room ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visit found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisitResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Visit not found", content = @Content)
    })
    @GetMapping("/{visitorId}/{waitingRoomId}")
    public VisitResponseDto getVisitById(
            @PathVariable @Parameter(description = "ID of the visitor") VisitorId visitorId,
            @PathVariable @Parameter(description = "ID of the waiting room") WaitingRoomId waitingRoomId) {
        return visitService.findById(visitorId, waitingRoomId);
    }

    @Operation(summary = "Subscribe a visitor to a waiting room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visitor subscribed successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisitResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content)
    })
    @PostMapping
    public ResponseEntity<VisitResponseDto> subscribeVisitor(
            @RequestBody @Parameter(description = "Data for the visitor's subscription") VisitRequestDto dto) {
        return ResponseEntity.ok(visitService.subscribeVisitor(dto));
    }

    @Operation(summary = "Cancel a visitor's subscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription canceled successfully"),
            @ApiResponse(responseCode = "404", description = "Visit not found", content = @Content)
    })
    @PutMapping("/{visitorId}/{waitingRoomId}/cancel")
    public void cancelSubscription(
            @PathVariable @Parameter(description = "ID of the visitor") VisitorId visitorId,
            @PathVariable @Parameter(description = "ID of the waiting room") WaitingRoomId waitingRoomId) {
        visitService.cancelSubscription(visitorId, waitingRoomId);
    }

    @Operation(summary = "Mark a visit as begun")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visit marked as begun",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisitResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Visit not found", content = @Content)
    })
    @PutMapping("/{visitorId}/{waitingRoomId}/begin")
    public VisitResponseDto beginVisit(
            @PathVariable @Parameter(description = "ID of the visitor") VisitorId visitorId,
            @PathVariable @Parameter(description = "ID of the waiting room") WaitingRoomId waitingRoomId) {
        return visitService.beginVisit(visitorId, waitingRoomId);
    }

    @Operation(summary = "Mark a visit as complete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visit marked as complete",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisitResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Visit not found", content = @Content)
    })
    @PutMapping("/{visitorId}/{waitingRoomId}/complete")
    public VisitResponseDto completeVisit(
            @PathVariable @Parameter(description = "ID of the visitor") VisitorId visitorId,
            @PathVariable @Parameter(description = "ID of the waiting room") WaitingRoomId waitingRoomId) {
        return visitService.completeVisit(visitorId, waitingRoomId);
    }

    @Operation(summary = "Delete a visit by visitor ID and waiting room ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Visit deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Visit not found", content = @Content)
    })
    @DeleteMapping("/{visitorId}/{waitingRoomId}")
    public void deleteVisit(
            @PathVariable @Parameter(description = "ID of the visitor") VisitorId visitorId,
            @PathVariable @Parameter(description = "ID of the waiting room") WaitingRoomId waitingRoomId) {
        visitService.delete(visitorId, waitingRoomId);
    }
}
