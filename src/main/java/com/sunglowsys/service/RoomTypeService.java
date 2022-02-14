package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoomTypeService {

    RoomType create(RoomType roomType);

    RoomType update(RoomType roomType);

    Optional<RoomType> findById(Long id);

    Page<RoomType> findAll(Pageable pageable);

    void delete(Long id);
}
