package org.sekou.lisamhotel.service;

import org.sekou.lisamhotel.model.BookedRoom;

import java.util.List;

public interface BookingRoomServiceImpl {

    List<BookedRoom> getAllBookingsByRoomsId(Long roomId);

    void cancleBooking(Long bookingId);

    String saveBooking(Long roomId, BookedRoom bookingRequest);

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> getAllBookingRooms();
}
