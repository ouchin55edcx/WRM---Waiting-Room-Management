package com.ouchin.WRM.waitingroom.service.impl;

import com.ouchin.WRM.exception.ResourceNotFoundException;
import com.ouchin.WRM.waitingroom.Embedded.WaitingRoomId;
import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import com.ouchin.WRM.waitingroom.mapper.WaitingRoomMapper;
import com.ouchin.WRM.waitingroom.repository.WaitingRoomRepository;
import com.ouchin.WRM.waitingroom.service.WaitingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WaitingRoomServiceImpl implements WaitingRoomService {

    private final WaitingRoomRepository waitingRoomRepository;
    private final WaitingRoomMapper waitingRoomMapper;

    @Autowired
    public WaitingRoomServiceImpl(WaitingRoomRepository waitingRoomRepository, WaitingRoomMapper waitingRoomMapper) {
        this.waitingRoomRepository = waitingRoomRepository;
        this.waitingRoomMapper = waitingRoomMapper;
    }

    @Override
    public Page<WaitingRoomResponseDto> findAll(int pageNum, int pageSize) {
        Page<WaitingRoom> waitingRooms = waitingRoomRepository.findAll(PageRequest.of(pageNum, pageSize));
        return waitingRooms.map(waitingRoomMapper::toDto);
    }

    @Override
    public WaitingRoomResponseDto findById(Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(new WaitingRoomId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Waiting room not found with ID: " + id));
        return waitingRoomMapper.toDto(waitingRoom);
    }

    @Override
    public WaitingRoomResponseDto create(WaitingRoomRequestDto waitingRoomRequestDto) {
        WaitingRoom waitingRoom = waitingRoomMapper.toEntity(waitingRoomRequestDto);
        WaitingRoom savedWaitingRoom = waitingRoomRepository.save(waitingRoom);
        return waitingRoomMapper.toDto(savedWaitingRoom);
    }

    @Override
    public WaitingRoomResponseDto update(Long id, WaitingRoomRequestDto waitingRoomRequestDto) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(new WaitingRoomId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Waiting room not found with ID: " + id));

        waitingRoom.setDate(waitingRoomRequestDto.getDate());
        waitingRoom.setCapacity(waitingRoomRequestDto.getCapacity());
        waitingRoom.setMode(waitingRoomRequestDto.getMode());
        waitingRoom.setAlgorithm(waitingRoomRequestDto.getAlgorithm());

        WaitingRoom updatedWaitingRoom = waitingRoomRepository.save(waitingRoom);
        return waitingRoomMapper.toDto(updatedWaitingRoom);
    }

    @Override
    public void delete(Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(new WaitingRoomId(id))
                .orElseThrow(() -> new ResourceNotFoundException("Waiting room not found with ID: " + id));
        waitingRoomRepository.delete(waitingRoom);
    }
}

