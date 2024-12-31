package Service;

import Model.*;

import java.util.*;
import java.util.stream.Collectors;


public class BookingService {
    static Map<Integer,Bookings> bookings = new HashMap<>();
    Map<Integer,Bill> bills=new HashMap<>();
    Map<Integer,RoomCustomer> roomCustomerMap=new HashMap<>();

    public void add(Room room, Customer customer, HotelSer hotel) {
        int bookingId=0;
        if (bookings.isEmpty()){
            bookingId=1;
        }
        else {
            bookingId = Collections.max(bookings.keySet())+1;
        }
        Date date = new Date();
        Bookings booking = new Bookings(bookingId,date,room,customer,hotel);
        bookings.put(bookingId,booking);
    }
    public static List<HotelSer> getHotelSer( ) {
        return bookings.values().stream()
                .map(Bookings::getHotelSer)
                .collect(Collectors.toList());
    }
    public List<Bookings>getBookings(Customer customer){
        return bookings.values().stream().filter(bookings1 -> bookings1.getCustomer().equals(customer)).toList();
    }
    public void NewBills(Customer customer, Room room) {

        int billId = bills.isEmpty() ? 1 : Collections.max(bills.keySet()) + 1;
        List<HotelSer> hotelServices = getHotelSer();
        Date date = new Date();
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Room Name: " + room.getRoomName());
        System.out.println("Date: " + date);
        int price = room.getPrice();
        for (HotelSer hotelSer : hotelServices) {
            System.out.println("Service Name: " + hotelSer.getSer_name());
            price += hotelSer.getSer_price();
        }

        System.out.println("Service price: " + price);

        Bill bill = new Bill(billId, room, price, date, customer);
        bills.put(billId, bill);
        room.setBooked(false);
        bookings.clear();
        roomCustomerMap.clear();
    }

    public void Connect(Customer customer, Room room) {

        int bookingId = 0;
        if (roomCustomerMap.isEmpty()) {
            bookingId = 1;
        } else {
            bookingId = Collections.max(roomCustomerMap.keySet()) + 1;
        }
        room.setBooked(true);
        RoomCustomer roomCustomer = new RoomCustomer(customer, bookingId, room);
        roomCustomerMap.put(bookingId, roomCustomer);
    }
}
