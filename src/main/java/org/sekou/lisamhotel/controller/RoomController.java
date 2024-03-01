package org.sekou.lisamhotel.controller;

import lombok.RequiredArgsConstructor;
import org.sekou.lisamhotel.model.Room;
import org.sekou.lisamhotel.response.RoomResponse;
import org.sekou.lisamhotel.service.RoomServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

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
}
