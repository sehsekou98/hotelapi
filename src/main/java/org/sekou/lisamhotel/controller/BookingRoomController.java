package org.sekou.lisamhotel.controller;


import lombok.RequiredArgsConstructor;
import org.sekou.lisamhotel.exception.InvalidBookingRequestException;
import org.sekou.lisamhotel.exception.ResourceNotFoundException;
import org.sekou.lisamhotel.model.BookedRoom;
import org.sekou.lisamhotel.model.Room;
import org.sekou.lisamhotel.response.BookingRoomResponse;
import org.sekou.lisamhotel.response.RoomResponse;
import org.sekou.lisamhotel.service.BookingRoomServiceImpl;
import org.sekou.lisamhotel.service.RoomServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingRoomController {
    private final BookingRoomServiceImpl bookingServiceImpl;
    private  final RoomServiceImp roomServiceImp;

    @GetMapping("all-bookings")
    public ResponseEntity<List<BookingRoomResponse>> getAllBookingRooms() {
        List<BookedRoom> bookings = bookingServiceImpl.getAllBookingRooms();
        List<BookingRoomResponse> bookingRoomResponses = new ArrayList<>();
        for (BookedRoom booking : bookings) {
            BookingRoomResponse bookingRoomResponse = getAllBookingRoomResponse(booking);
            bookingRoomResponses.add(bookingRoomResponse);
        }
        return ResponseEntity.ok(bookingRoomResponses);
    }


    @GetMapping("/confirmation/{confirmationCode}")
    public ResponseEntity<?> getBookingByConfirmationCode(@PathVariable String confirmationCode) {
        try {
            BookedRoom booking = bookingServiceImpl.findByBookingConfirmationCode(confirmationCode);
            BookingRoomResponse bookingRoomResponse = getAllBookingRoomResponse(booking);
            return ResponseEntity.ok(bookingRoomResponse);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }



    @PostMapping("/room/{roomId}/booking")
    public ResponseEntity<?> saveBooking(@PathVariable Long roomId,
                                         @RequestBody BookedRoom bookingRequest) {
        try{
            String confirmationCode = bookingServiceImpl.saveBooking(roomId, bookingRequest);
            return ResponseEntity.ok("Room booked successfully ! Your booking confirmation code is :" + confirmationCode);
        } catch (InvalidBookingRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/booking/{bookingId}/delete")
    public void cancleBooking(Long bookingId) {
        bookingServiceImpl.cancleBooking(bookingId);

    }

    private BookingRoomResponse getAllBookingRoomResponse(BookedRoom booking) {
        Room theRoom = roomServiceImp.getRoomById(booking.getRoom().getId()).get();
        RoomResponse room = new RoomResponse(theRoom.getId(), theRoom.getRoomType(), theRoom.getRoomPrice());
        return new BookingRoomResponse(booking.getBookingId(), booking.getCheckInDate(), booking.getCheckOutDate(),
                booking.getGuestFullName(), booking.getGuestEmail(),
                booking.getNumOfAdults(), booking.getNumOfChildren(),
                booking.getTotalNumberOfGuest(),
                booking.getBookingConfirmationCode(),
                room);
    }

}
