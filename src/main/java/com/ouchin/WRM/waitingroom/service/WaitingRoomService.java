package com.ouchin.WRM.waitingroom.service;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.service.base.CrudService;

public interface WaitingRoomService extends CrudService<Integer, WaitingRoomRequestDto, WaitingRoomResponseDto> {
    
}
