package com.company;

public class Room {

    private String roomName;
    private int roomSize;

    public Room(String roomName, int roomSize) {
        this.roomName = roomName;
        this.roomSize = roomSize;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomSize() {
        return roomSize;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomSize=" + roomSize +
                '}';
    }
}
