package org.sekou.lisamhotel.repository;

import org.sekou.lisamhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
