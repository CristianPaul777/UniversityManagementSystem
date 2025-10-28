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

    public Room addRoom(Room room) {
        return repo.save(room);
    }

    public void deleteRoom(String id) {
        repo.deleteById(id);
    }
}
