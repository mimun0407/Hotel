package Service;
import Model.HotelSer;

import java.util.HashMap;
import java.util.Map;

public class HotelService {
    Map<Integer, HotelSer> hotelSerMap=new HashMap<>();

    public void addHotel(){
        hotelSerMap.put(1, new HotelSer(1,100 , "Room Cleaning"));
        hotelSerMap.put(2, new HotelSer(2, 200, "Laundry Service"));
        hotelSerMap.put(3, new HotelSer(3,500, "Spa Service"));
        hotelSerMap.put(4, new HotelSer(4, 300, "Breakfast Buffet"));
        hotelSerMap.put(5, new HotelSer(5, 400, "Airport Shuttle"));
    }
    public void allHotelSer(){
        String leftAlignFormat = "| %-17s | %-4d |%6d $|%n";
        System.out.format("+-------------------+------+--------+%n");
        System.out.format("|  Column name      | ID   |   price  |%n");
        System.out.format("+-------------------+------+--------+%n");
        for(HotelSer hotelSer:hotelSerMap.values()){
            System.out.format(leftAlignFormat, hotelSer.getSer_name(), hotelSer.getSer_id(),hotelSer.getSer_price());     }
        System.out.format("+-------------------+------+--------+%n");
    }
    public HotelSer getHotelSer(int id){
        return hotelSerMap.get(id);
    }
}
