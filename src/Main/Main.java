package Main;

import Model.Customer;
import Model.Room;
import Service.*;

import java.util.Scanner;

public class Main {
    static CustomerService customerService = new CustomerService();
    static HotelService hotelService = new HotelService();
    static BookingService bookingService = new BookingService();
    static RoomService roomService = new RoomService();
    static int idUser=0;
    static int idRoom=0;
    static int idHotel=0;



    public static void main(String[] args) {
        customerService.addCustomer();
        hotelService.addHotel();
        roomService.add();
        boolean check=true;

        Scanner input = new Scanner(System.in);
        while (check) {
            System.out.println("---------------------Welcome to my program, Please enter Customer ID: -------------------------------");
            customerService.getAllCustomer();
            System.out.println("6, Exit");
            int idCus = input.nextInt();
            if (idCus == 6) {
                check = false;
                break;
            }

            switch (idCus) {
                case 1: idUser = 1; break;
                case 2: idUser = 2; break;
                case 3: idUser = 3; break;
                case 4: idUser = 4; break;
                case 5: idUser = 5; break;
                default:
                    System.out.println("Invalid Customer ID. Please try again.");
                    continue;
            }

            Customer cus = customerService.getCustomerById(idCus);
            boolean checkRoom = true;

            while (checkRoom) {
                System.out.println("-------------------------please enter room number: --------------------------");
                roomService.getAllRoom();
                System.out.println("6, Back to Chosen User");
                int room = input.nextInt();

                if (room == 6) {
                    checkRoom = false;
                    break;
                }

                switch (room) {
                    case 1: idRoom = 1; break;
                    case 2: idRoom = 2; break;
                    case 3: idRoom = 3; break;
                    case 4: idRoom = 4; break;
                    case 5: idRoom = 5; break;
                    default:
                        System.out.println("Invalid room number. Please try again.");
                        continue;
                }

                Room r = roomService.getRoomById(room);
                if (r.isBooked()){
                    System.out.println("This room already booked for this room. Please try again.");
                    checkRoom = false;
                    break;
                }
                else {
                    bookingService.Connect(cus, r);
                }

                boolean checkHotel = true;
                while (checkHotel) {
                    System.out.println("---------------------Do you want to Service------------------?");
                    hotelService.allHotelSer();
                    System.out.println("6, Check Bill");

                    int hotelServiceID = input.nextInt();
                    if (hotelServiceID == 6) {
                        bookingService.NewBills(cus, r);
                        checkHotel = false;
                        checkRoom = false;
                        break;
                    }

                    switch (hotelServiceID) {
                        case 1: idHotel = 1; break;
                        case 2: idHotel = 2; break;
                        case 3: idHotel = 3; break;
                        case 4: idHotel = 4; break;
                        case 5: idHotel = 5; break;
                        default:
                            System.out.println("Invalid service number. Please try again.");
                            continue;
                    }

                    bookingService.add(r, cus, hotelService.getHotelSer(idHotel));
                }
            }
        }
    }
}
