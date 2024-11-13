package com.ouchin.WRM.waitingroom.service;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.service.base.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface WaitingRoomService extends CrudService<Long, WaitingRoomRequestDto, WaitingRoomResponseDto> {

}
