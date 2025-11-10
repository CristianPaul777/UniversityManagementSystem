package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Room;
import com.example.University.Management.System.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    public List<Room> getAllRooms() {
        return repo.findAll();
    }

    public Room getRoomById(String id) {
        return repo.findById(id);
    }

    public Room addRoom(Room room) {
        return repo.save(room);
    }


    public Room updateRoom(String id, Room updatedRoom) {
        Room existing = repo.findById(id);
        if (existing != null) {
            updatedRoom.setId(id);
            repo.deleteById(id);
            repo.save(updatedRoom);
            return updatedRoom;
        }
        return null;
    }

    public void deleteRoom(String id) {
        repo.deleteById(id);
    }
}
