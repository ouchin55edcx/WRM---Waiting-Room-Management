package com.ouchin.WRM.waitingroom.service.impl;

import com.ouchin.service.WaitingRoomService;
import com.ouchin.dto.WaitingRoomRequestDto;
import com.ouchin.dto.WaitingRoomResponseDto;
import com.ouchin.repository.WaitingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaitingRoomServiceImpl implements WaitingRoomService {

    @Autowired
    private WaitingRoomRepository waitingRoomRepository;

    @Override
    public List<WaitingRoomResponseDto> findAll() {
        return waitingRoomRepository.findAll().stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    public WaitingRoomResponseDto findById(Integer id) {
        return waitingRoomRepository.findById(id)
            .map(this::convertToResponseDto)
            .orElseThrow(() -> new RuntimeException("WaitingRoom not found"));
    }

    @Override
    public WaitingRoomResponseDto create(WaitingRoomRequestDto dto) {
        // Convert dto to entity, save, then return the response DTO
        // Assuming conversion and repository save here
        return convertToResponseDto(waitingRoomRepository.save(convertToEntity(dto)));
    }

    @Override
    public WaitingRoomResponseDto update(Integer id, WaitingRoomRequestDto dto) {
        // Update logic here
        // Retrieve the existing entity, update it, then save and return the updated response DTO
        return convertToResponseDto(waitingRoomRepository.save(convertToEntity(dto)));
    }

    @Override
    public void delete(Integer id) {
        waitingRoomRepository.deleteById(id);
    }



}
