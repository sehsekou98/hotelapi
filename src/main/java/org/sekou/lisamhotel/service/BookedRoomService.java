package org.sekou.lisamhotel.service;


import org.sekou.lisamhotel.model.BookedRoom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedRoomService implements BookedRoomServiceImpl{

    @Override
    public List<BookedRoom> getAllBookingsByRoomsId(Long roomId) {
        return null;
    }
}
