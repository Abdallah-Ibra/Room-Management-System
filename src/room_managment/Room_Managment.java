package room_managment;

/*
   ### Room Management System Project _For Students_ ||Created By: Abdallah Ibrahim|| ###
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Room_Managment {

    public static int numOfRooms = 40;
    public static int[] seats;
    public static String[][] arraystatus = new String[10][4];
    public static int numRoomsForReserved, numRoomsForDelete;

    public static ArrayList<String> arrayReserve = new ArrayList<>();

    public static void menu() {
        System.out.print("\n1. Display number of available rooms.\n" + "2. Display room status for all rooms.\n"
                + "3. Reserve a room(s).\n" + "4. Cancel reservation(s).\n" + "5. Exit.\n"
                + "Please select your choice:");
    }

    public static void main(String[] args) {
        System.out.println("\n################################################################\n"
                + "################### Welcome To Our Hotel! ######################\n"
                + "################################################################");
        int n = 0;
        Scanner input = new Scanner(System.in);
        int arr[] = new int[40];
        for (int i = 0; i < 40; i++) {
            arr[i] = 0;
        }
        while (n != 5) {
            System.out.println();
            menu();
            n = input.nextInt();
            System.out.println();
            switch (n) {
                case 1:
                    display_available();
                    break;

                case 2:
                    display_status(arr);
                    break;
                case 3:
                    reserve_rooms(arr);
                    break;
                case 4:
                    cancel_rooms(arr);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice! Please Choose a number between 1-5..");
                    menu();
            }
        }
    }

    /* function to cancel a room */
    public static void cancel_rooms(int[] arr) {
        Scanner input = new Scanner(System.in);
        if (arrayReserve.isEmpty()) {
            System.out.println("You cannot delete any reservation");
        } else {
            System.out.print("Enter the room that you want to delete: ");
            numRoomsForDelete = input.nextInt();
            if (arrayReserve.contains(numRoomsForDelete + "")) {
                arrayReserve.remove(new String(numRoomsForDelete + ""));
                numOfRooms++;
                System.out.println("The room Reservation was cancelled!");
            } else {
                System.out.println("This room is not reserved!");
            }

        }
        System.out.println("");
        System.out.print("Enter any key to continue...");
        String press = input.nextLine();
    }

    /* function to reserve a room */
    public static void reserve_rooms(int[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.print("There are " + numOfRooms + " Rooms available. please enter required number of Room:");
        numRoomsForReserved = input.nextInt();
        int i = 1;
        while (i <= numRoomsForReserved) {
            System.out.print("Enter a number of required Room: ");
            int roomxx = input.nextInt();
            if (roomxx > 0 && roomxx < 41) {
                String m = String.valueOf(roomxx);
                if (!arrayReserve.contains(m)) {
                    arrayReserve.add(m);
                    numOfRooms--;
                    i++;
                } else {
                    System.out.println("The Room is reserved, please choose another room!");
                }
            } else {
                System.out.println("Please Enter a Room number between 1 and 40 only... Thank you!");
            }
        }
        System.out.println("Required Room(s) successfully reserved. ");
        System.out.print("Enter any key to continue...");
        String press = input.nextLine();
    }


    /* function to display status of all rooms */
    public static void display_status(int[] arr) {
        String reserved = "reserved";
        String numseats = "1";
        int i = 0;
        for (i = 0; i < arraystatus.length; i++) {
            for (int j = 0; j <= 3; j++) {
                int intNumSeats = Integer.parseInt(numseats);

                if (arrayReserve.contains(numseats)) {
                    arraystatus[i][j] = reserved;
                    System.out.print("[   " + arraystatus[i][j] + "   ]");
                } else {
                    arraystatus[i][j] = numseats;
                    System.out.print("[\t" + arraystatus[i][j] + "\t]");
                }

                intNumSeats++;
                numseats = String.valueOf(intNumSeats);
                if (j == 3) {
                    System.out.println("");
                }

            }
        }
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter any key to continue...");
        String press = input.nextLine();
    }

    /* function to count number of available rooms */
    public static void display_available() {
        System.out.println("Number of available seats = " + numOfRooms);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any key to continue...");
        String press = input.nextLine();
    }
}
