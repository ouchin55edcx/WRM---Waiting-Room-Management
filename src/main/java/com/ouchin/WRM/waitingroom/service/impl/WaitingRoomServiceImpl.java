package com.ouchin.WRM.waitingroom.service.impl;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import com.ouchin.WRM.waitingroom.mapper.WaitingRoomMapper;
import com.ouchin.WRM.waitingroom.repository.WaitingRoomRepository;
import com.ouchin.WRM.waitingroom.service.WaitingRoomService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class WaitingRoomServiceImpl implements WaitingRoomService {

    private final WaitingRoomRepository waitingRoomRepository;
    private final WaitingRoomMapper waitingRoomMapper;

    @Override
    public Page<WaitingRoomResponseDto> findAll(int pageNum, int pageSize) {
        return waitingRoomRepository.findAll(PageRequest.of(pageNum, pageSize))
                .map(waitingRoomMapper::toResponseDto);
    }

    @Override
    public WaitingRoomResponseDto findById(Long id) {
        return waitingRoomMapper.toResponseDto(findEntityById(id));
    }

    @Override
    public WaitingRoomResponseDto create(WaitingRoomRequestDto dto) {
        WaitingRoom waitingRoom = waitingRoomMapper.toEntity(dto);
        return waitingRoomMapper.toResponseDto(waitingRoomRepository.save(waitingRoom));
    }

    @Override
    public WaitingRoomResponseDto update(Long id, WaitingRoomRequestDto dto) {
        WaitingRoom existingWaitingRoom = findEntityById(id);
        waitingRoomMapper.updateFromDto(dto, existingWaitingRoom);
        return waitingRoomMapper.toResponseDto(waitingRoomRepository.save(existingWaitingRoom));
    }

    @Override
    public void delete(Long id) {
        if (!waitingRoomRepository.existsById(id)) {
            throw new EntityNotFoundException("WaitingRoom not found with id: " + id);
        }
        waitingRoomRepository.deleteById(id);
    }

    @Override
    public WaitingRoom findEntityById(Long id) {
        return waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WaitingRoom not found with id: " + id));
    }
}