package com.example.University.Management.System.repository;


import com.example.University.Management.System.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private List<Room> rooms = new ArrayList<>();

    public Room save(Room room) {
        rooms.add(room);
        return room;
    }

    public List<Room> findAll() {
        return new ArrayList<>(rooms);
    }

    public Room findById(String id) {
        for (Room r : rooms) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return rooms.removeIf(r -> r.getId().equals(id));
    }

}
