package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType create(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType, Long id) {
        RoomType roomType1 = roomTypeRepository.findById(id).get();
        roomType1 .setName(roomType.getName());
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType findRoomTypeById(Long id) {
        return roomTypeRepository.getById(id);
    }

    @Override
    public List<RoomType> findAllRoomType() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        roomTypeRepository.deleteById(id);

    }
}
