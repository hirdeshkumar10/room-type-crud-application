package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomTypeService {



    RoomType create(RoomType roomType);

    RoomType update(RoomType roomType, Long id);

    RoomType findRoomTypeById(Long id);

    List<RoomType> findAllRoomType();

    void delete(Long id);
}
