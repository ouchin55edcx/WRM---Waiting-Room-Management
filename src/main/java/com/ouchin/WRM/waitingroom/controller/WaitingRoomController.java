package com.ouchin.WRM.waitingroom.controller;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.service.WaitingRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/waiting-rooms")
public class WaitingRoomController {

    private final WaitingRoomService waitingRoomService;

    @Autowired
    public WaitingRoomController(WaitingRoomService waitingRoomService) {
        this.waitingRoomService = waitingRoomService;
    }

    @Operation(summary = "Get all waiting rooms (paginated)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found waiting rooms",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Page.class)))
    })
    @GetMapping
    public ResponseEntity<Page<WaitingRoomResponseDto>> getAllWaitingRooms(
            @RequestParam(defaultValue = "0") @Parameter(description = "Page number") int pageNum,
            @RequestParam(defaultValue = "10") @Parameter(description = "Page size") int pageSize) {
        Page<WaitingRoomResponseDto> response = waitingRoomService.findAll(pageNum, pageSize);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get waiting room by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the waiting room",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WaitingRoomResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Waiting room not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<WaitingRoomResponseDto> getWaitingRoomById(
            @PathVariable @Parameter(description = "ID of the waiting room") Long id) {
        WaitingRoomResponseDto response = waitingRoomService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create new waiting room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Waiting room created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WaitingRoomResponseDto.class)))
    })
    @PostMapping
    public ResponseEntity<WaitingRoomResponseDto> createWaitingRoom(
            @RequestBody @Valid @Parameter(description = "Waiting room data") WaitingRoomRequestDto dto) {
        WaitingRoomResponseDto response = waitingRoomService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update waiting room by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Waiting room updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WaitingRoomResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Waiting room not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<WaitingRoomResponseDto> updateWaitingRoom(
            @PathVariable @Parameter(description = "ID of the waiting room") Long id,
            @RequestBody @Valid @Parameter(description = "Updated waiting room data") WaitingRoomRequestDto dto) {
        WaitingRoomResponseDto response = waitingRoomService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete waiting room by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Waiting room deleted"),
            @ApiResponse(responseCode = "404", description = "Waiting room not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaitingRoom(
            @PathVariable @Parameter(description = "ID of the waiting room") Long id) {
        waitingRoomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
