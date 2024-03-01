package org.sekou.lisamhotel.controller;

import lombok.RequiredArgsConstructor;
import org.sekou.lisamhotel.model.Room;
import org.sekou.lisamhotel.response.RoomResponse;
import org.sekou.lisamhotel.service.RoomServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomServiceImp roomServiceImp;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse>addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice) throws SQLException, IOException {

        Room saveRoom = roomServiceImp.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(saveRoom.getId(),
                saveRoom.getRoomType(),
                saveRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/room/types")
    public List<String> getRoomTypes() {
        return roomServiceImp.getAllRoomTypes();
    }
}
