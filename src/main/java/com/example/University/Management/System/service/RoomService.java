package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Room;
import com.example.University.Management.System.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    public List<Room> getAllRooms(String sort, String order, String numberFilter, String buildingFilter) {

        List<Room> rooms = repo.findAll();

        // FILTER
        if (numberFilter != null && !numberFilter.isEmpty()) {
            rooms = rooms.stream()
                    .filter(r -> r.getNumber().toLowerCase().contains(numberFilter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (buildingFilter != null && !buildingFilter.isEmpty()) {
            rooms = rooms.stream()
                    .filter(r -> r.getBuilding().toLowerCase().contains(buildingFilter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // SORT
        if (sort != null) {
            Comparator<Room> comparator = switch (sort) {
                case "number" -> Comparator.comparing(Room::getNumber);
                case "building" -> Comparator.comparing(Room::getBuilding);
                case "capacity" -> Comparator.comparingDouble(Room::getCapacity); // aici era eroarea!
                default -> null;
            };

            if (comparator != null) {
                if ("desc".equals(order)) {
                    comparator = comparator.reversed();
                }
                rooms = rooms.stream().sorted(comparator).collect(Collectors.toList());
            }
        }

        return rooms;
    }

    public Room getRoomById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Room addRoom(Room room) {
        return repo.save(room);
    }

    public Room updateRoom(String id, Room updatedRoom) {
        if (repo.existsById(id)) {
            updatedRoom.setId(id);
            return repo.save(updatedRoom);
        }
        return null;
    }

    public void deleteRoom(String id) {
        repo.deleteById(id);
    }
}
