package org.sekou.lisamhotel.service;

import org.sekou.lisamhotel.model.BookedRoom;

import java.util.List;

public interface BookedRoomServiceImpl {
    List<BookedRoom> getAllBookingsByRoomsId(Long roomId);
}
