package Service;

import Model.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    Map<Integer, Room> roomMap=new HashMap<>();
    public void add(){
        roomMap.put(1, new Room(1, "Room A", false,199));
        roomMap.put(2, new Room(2, "Room B", false,200));
        roomMap.put(3, new Room(3, "Room C", false,600));
        roomMap.put(4, new Room(4, "Room D",false ,400));
        roomMap.put(5, new Room(5, "Room E",false,300));
    }
    public void getAllRoom(){
        String leftAlignFormat = "| %-15s | %-4d |%6s |%n";

        System.out.format("+-----------------+------+-------+%n");
        System.out.format("| Column name     | ID   |booked |%n");
        System.out.format("+-----------------+------+-------+%n");
        for(Room r:roomMap.values()){
            System.out.format(leftAlignFormat, r.getRoomName(), r.getIdRoom(),r.isBooked());
        }
        System.out.format("+-----------------+------+-------+%n");

    }
    public Room getRoomById(int id){
        return roomMap.get(id);
    }
}
