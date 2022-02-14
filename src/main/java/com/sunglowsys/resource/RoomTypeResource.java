package com.sunglowsys.resource;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomTypeResource {

    private final Logger log = LoggerFactory.getLogger(RoomTypeResource.class);


    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping("/room-types")
    public ResponseEntity<?> create(@RequestBody RoomType roomType) throws URISyntaxException {
        log.debug(" Rest Request to save Room Type: {}",roomType);
        if (roomType.getId() != null){
            throw new RuntimeException("Id should be null in api calls");
        }
        RoomType result = roomTypeService.create(roomType);
        return ResponseEntity
                .created(new URI("/api/room-types/"+result.getId()))
                .body("RoomType is created successfully: " + result);
    }

    @GetMapping("/room-types")
    public ResponseEntity<List<RoomType>> getAllRoomType(Pageable pageable) {
        log.debug(" Rest Request to get all Room Types: {}",pageable.toString());
        Page<RoomType> result = roomTypeService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/room-types/{id}")
    public ResponseEntity<RoomType> findRoomTypeById(@PathVariable Long id) {
        log.debug("Rest Request to getById Room Type: {}",id);
        Optional<RoomType> result = roomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }
    @PutMapping("/room-types")
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType) {
        log.debug("Rest Request to delete Room Type: {}",roomType);
        if (roomType.getId() == null){
            throw new RuntimeException("Id should not be null ion api calls");
        }
        RoomType result = roomTypeService.update(roomType);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @DeleteMapping("/room-types/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        log.debug("Rest Request to delete Room Type: {}",id);
        return ResponseEntity
                .ok()
                .build();
    }
}
