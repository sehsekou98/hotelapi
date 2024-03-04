package org.sekou.lisamhotel.service;


import org.sekou.lisamhotel.model.BookedRoom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRoomService implements BookingRoomServiceImpl {

    @Override
    public List<BookedRoom> getAllBookingsByRoomsId(Long roomId) {
        return null;
    }

    @Override
    public void cancleBooking(Long bookingId) {

    }

    @Override
    public String saveBooking(Long roomId, BookedRoom bookingRequest) {
        return null;
    }

    @Override
    public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
        return null;
    }

    @Override
    public List<BookedRoom> getAllBookingRooms() {
        return null;
    }
}
