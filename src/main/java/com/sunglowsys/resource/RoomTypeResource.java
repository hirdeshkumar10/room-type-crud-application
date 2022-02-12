package com.sunglowsys.resource;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomTypeResource {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/roomTypes")
    public ResponseEntity<?> create(@RequestBody RoomType roomType) {
        RoomType roomType1 = roomTypeService.create(roomType);
        return ResponseEntity.ok().body("RoomType is created successfully: " + roomType1);
    }
    @GetMapping("/roomTypes")
    public ResponseEntity<List<RoomType>> getAllRoomType() {
        List<RoomType> result = roomTypeService.findAllRoomType();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/roomTypes/{id}")
    public ResponseEntity<RoomType> findRoomTypeById(@PathVariable("id") Long id) {
        RoomType roomType = roomTypeService.findRoomTypeById(id);
        return ResponseEntity.ok().body(roomType);
    }
    @PutMapping("/roomTypes/{id}")
    public RoomType update(@RequestBody RoomType roomType, @PathVariable("id") Long id) {
        return roomTypeService.update(roomType, id);
    }
    @DeleteMapping("/roomTypes/{id}")
    public void delete(@PathVariable("id") Long id) {
        roomTypeService.delete(id);
    }
}
