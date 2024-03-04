package org.sekou.lisamhotel.repository;

import org.sekou.lisamhotel.model.BookedRoom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRoomRepository {
    void deleteById(Long bookingId);

    List<BookedRoom> findAll();

    List<BookedRoom> findBookingsByRoomId(Long roomId);

    Optional<Object> findByBookingConfirmationCode(String confirmationCode);

    void save(BookedRoom bookingRequest);
}
