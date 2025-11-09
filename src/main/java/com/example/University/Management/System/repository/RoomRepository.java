package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository extends InFileRepository<Room> {

    public RoomRepository() {
        super("rooms.json", Room.class);
    }
}
