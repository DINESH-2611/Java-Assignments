package AdminUser;

import datalayer.TrainBookingDatabse;
import model.Passenger;
import model.Ticket;
import model.TrainRoutes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminUserView {
    Scanner scanner = new Scanner(System.in);
    private AdminUserModel adminUserModel;

    public AdminUserView() {
        adminUserModel = new AdminUserModel(this);
    }

    public void adminPage() {
        while (true) {
            System.out.println("1.Add train Routes\n2.Change Ticket status of a passenger\n3.View booked Tickets\n4.View All Trains\n5.Back to Home page\nEnter the choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    getTrainDetails();
                    break;
                case "2":
                    getPNR();
//                    adminUserModel.showTickets();
//                    adminUserModel.showPassengers();
                    break;
                case "3":
                    adminUserModel.getAllTickets();
                    break;
                case "4":
                    adminUserModel.showTrains();
                    break;
                case "5":
                    TrainBookingDatabse.getInstance().saveAll();
                    break;
                default:
                    showAlert("Invalid choice,Enter valid choice");
                    break;
            }
            if (choice.equals("5"))
                break;
        }
    }

    private void getPNR() {
        System.out.println("Enter PNR number");
        int pnr = Integer.parseInt(scanner.nextLine());
        adminUserModel.isvalidPnr(pnr);
    }

    private void getTrainDetails() {
        System.out.println("Enter no of train routes");
        int routes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < routes; i++) {
            System.out.println("Enter Schedule " + (i + 1));
            System.out.println("Enter train name");
            String name = scanner.nextLine();
            System.out.println("Enter departure time in 'HH:MM' format");
            String departure = scanner.nextLine();
            System.out.println("Enter arrival time in 'HH:MM' format");
            String arrival = scanner.nextLine();
            System.out.println("Enter no of seats in the train(In numbers)");
            int seats = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter fare(In numbers)");
            int fare = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter no of stops for the routes(In numbers)");
            int stop = Integer.parseInt(scanner.nextLine());
            List<String> stops = new ArrayList<>();
            for (int j = 0; j < stop; j++) {
                System.out.println("Enter stop name");
                stops.add(scanner.nextLine());
            }
            adminUserModel.addTrainRoutes(name, departure, arrival, seats, fare, stops);
        }
        showAlert(routes + " train routes added succesfully");
    }

    void showAlert(String s) {
        System.out.println(s);
    }

    public void userPage(String userName) {
        while (true) {
            System.out.println("1.Booking\n2.Get PNR status\n3.Cancel Tickets\n4.Search Passengers\n5.List Train routes\n6.Back to Home page\nEnter the choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    getStatEndpoint(userName, 1);
                    break;
                case "2":
                    getPnrNumber();
                    break;
                case "3":
                    getPnr();
                    break;
                case "4":
                    getPassengersId();
                    break;
                case "5":
                    getStatEndpoint(userName, 5);
                    break;
                case "6":
                    TrainBookingDatabse.getInstance().saveAll();
                    break;
                default:
                    showAlert("Invalid choice,Enter valid choice");
            }
            if (choice.equals("6"))
                break;
        }
    }

    private void getPassengersId() {
        System.out.println("Enter passenger id");
        int id = Integer.parseInt(scanner.nextLine());
        adminUserModel.isPassengerExist(id);
    }

    private void getPnr() {
        System.out.println("Enter pnr number");
        int pnr = Integer.parseInt(scanner.nextLine());
        adminUserModel.isPnrExist(pnr);
    }

    private void getPnrNumber() {
        System.out.println("Enter pnr number");
        int pnr = Integer.parseInt(scanner.nextLine());
        adminUserModel.validatePnr(pnr);
    }

    private void getStatEndpoint(String userName, int i) {
        System.out.println("Enter from station");
        String from = scanner.nextLine();
        System.out.println("Enter from station");
        String to = scanner.nextLine();
        adminUserModel.getAvailabletrains(from, to, userName, i);
    }

    public void showTrains(List<TrainRoutes> availabletrains) {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %25s %15s %15s %25s %25s %25s", "Train Number", "Train Name", "Departure Time", "Arrival Time", "Fare", "Seats","Waiting List\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (TrainRoutes trainRoutes : availabletrains) {
            List<String> routes = trainRoutes.getRoutes();
//            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%10s %25s %15s %15s %25s %25s %25s", trainRoutes.getTrainNo(), trainRoutes.getTrainName(), trainRoutes.getDepartureTime(), trainRoutes.getArrivalTime(), trainRoutes.getFare(), trainRoutes.getSeats(),trainRoutes.getWaitingList()+"\n");
//            System.out.println();
            System.out.print("Routes: ");
            for (String s : routes)
                System.out.print(s + ",");
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------------------------------");

        }

    }

    public void getTrainNo(List<TrainRoutes> availabletrains, String from, String to, String userName) {
        System.out.println("Enter train number");
        int trainNo = Integer.parseInt(scanner.nextLine());
        adminUserModel.isvalidTrain(availabletrains, trainNo, from, to, userName);
    }

    public void getpassengersCount(TrainRoutes trainRoutes,String from, String to, String userName, List<TrainRoutes> availabletrains) {
        System.out.println("Enter no of passengers");
        int passengers = Integer.parseInt(scanner.nextLine());
        if (trainRoutes.getSeats() >= passengers) {
            getpassengersDetails(trainRoutes, passengers, from, to, userName, availabletrains, -1);
        } else if (passengers - trainRoutes.getSeats() <= trainRoutes.getWaitingList()) {
            getpassengersDetails(trainRoutes, passengers, from, to, userName, availabletrains, 0);
        } else {
            showAlert("Passengers exceeds the train seat availability");
            getpassengersCount(trainRoutes, from, to, userName, availabletrains);
        }
    }

    private void getpassengersDetails(TrainRoutes trainRoutes, int passengers, String from, String to, String userName, List<TrainRoutes> availabletrains, int waitingList) {
        Passenger[] passengers1 = new Passenger[passengers];
        for (int i = 0; i < passengers; i++) {
            System.out.println("Enter passengers " + (i + 1) + " details");
            System.out.println("Enter passenger name");
            String name = scanner.nextLine();
            System.out.println("Enter age");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gender");
            String gender = scanner.nextLine();
            Passenger passenger = new Passenger();
            passenger.setName(name);
            passenger.setAge(age);
            passenger.setGender(gender);
            passenger.setId((int) (Math.random() * 10000 + (int) (Math.random() * 100)));
            if (waitingList == -1)
                passenger.setStatus("CNF");
            else {
                if (i < trainRoutes.getSeats())
                    passenger.setStatus("CNF");
                else
                    passenger.setStatus("WL");
            }
            passengers1[i] = passenger;
        }
        bookOrCancel(trainRoutes, passengers, passengers1, from, to, userName, availabletrains,waitingList);

    }

    private void bookOrCancel(TrainRoutes trainRoutes, int passengers, Passenger[] passengers1, String from, String to, String userName, List<TrainRoutes> availabletrains, int waitingList) {
        int start=-1,end=-1;
        List<String > routes=trainRoutes.getRoutes();
        int totalfare=0;
        if(routes.get(0).equalsIgnoreCase(from) && routes.get(routes.size()-1).equalsIgnoreCase(to)){
            totalfare = trainRoutes.getFare() * passengers;
        }else {
            for (int i = 0; i <routes.size() ; i++) {
                if(routes.get(i).equalsIgnoreCase(from))
                    start=i;
                if(routes.get(i).equalsIgnoreCase(to))
                    end=i;
            }
            totalfare=(end-start)*(trainRoutes.getFare()/routes.size()-1)*passengers;
        }
        showAlert("Total Fare:" + totalfare + "\nPay:\n1.Pay\n2.Cancel\n3.Reschedule\nEnter the choice");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if(waitingList==-1) {
                    adminUserModel.bookTicket(trainRoutes, passengers1, from, to, totalfare, userName);
                    trainRoutes.setSeats(trainRoutes.getSeats() - passengers);
                }else{
                    adminUserModel.bookTicket(trainRoutes, passengers1, from, to, totalfare, userName);
                    trainRoutes.setSeats(0);
                    trainRoutes.setWaitingList(trainRoutes.getWaitingList()-(passengers-trainRoutes.getSeats()));
                }
                break;
            case "2":
                showAlert("Payment Cancelled");
                break;
            case "3":
                getTrainNo(availabletrains, from, to, userName);
                break;
            default:
                showAlert("Invalid choice,Enter valid choice");
                bookOrCancel(trainRoutes, passengers, passengers1, from, to, userName, availabletrains, waitingList);
        }
    }
    public void getTicketStatus(int pnr) {
        System.out.println("Enter Ticket status\n1.CNF\n2.Waiting\n3.Cancel");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                adminUserModel.updateStatus(pnr, "CNF");
                break;
            case "2":
                adminUserModel.updateStatus(pnr, "WL");
                break;
            case "3":
                adminUserModel.updateStatus(pnr, "Cancel");
                break;
            default:
                showAlert("Invalid choice,Enter valid choice");
                getTicketStatus(pnr);
        }
    }

    public void showTickets(List<Ticket> tickets) {
        if (tickets.isEmpty()) {
            showAlert("Tickets list is empty");
            return;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %25s %15s %15s %25s %25s %20s %20s", "Train Number", "Train Name", "Departure Time", "Arrival Time", "Source", "Destination", "PNR NO", "Total fare\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Ticket ticket : tickets) {
//            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%10s %25s %15s %15s %25s %25s %20s %20s", ticket.getTrainNo(), ticket.getTrainName(), ticket.getDepartureTime(), ticket.getArrivalTime(), ticket.getFrom(), ticket.getTo(), ticket.getPnrNo(), ticket.getTotalfare() + "\n");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
//            int pnr= ticket.getPnrNo();
//            adminUserModel.getPassenger(pnr);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------\n\n");


    }

    public void showPassengers(List<Passenger> getpassengers) {
        if (getpassengers.isEmpty()) {
            showAlert("Passengers list is empty");
            return;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %15s %15s %15s %20s %20s", "Name", "Age", "ID", "Gender","PNR no", "Status\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Passenger passenger : getpassengers) {
//            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %15s %15s %15s %20s %20s", passenger.getName(), passenger.getAge(), passenger.getId(), passenger.getGender(),passenger.getPnr(), passenger.getStatus() + "\n");
            System.out.println("------------------------------------------------------------------------------------------------------------------");

        }
//        System.out.println("------------------------------------------------------------------------------------------------------------------");


    }

    public void checkForcancel(int pnr, Ticket ticket) {
        System.out.println("Do you want to cancel the ticket?");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            adminUserModel.cancelTicket(pnr, ticket);
        }
    }

    public void showTicketsWithPassengers(List<Ticket> allTickets) {
        if (allTickets.isEmpty()) {
            showAlert("Tickets list is empty");
            return;
        }
        System.out.println("Passenger List");
        System.out.println("------------------------------------------------------------------------------------------------------------------\n\n");
        System.out.printf("%10s %25s %15s %15s %25s %25s %20s %20s", "Train Number", "Train Name", "Departure Time", "Arrival Time", "Source", "Destination", "PNR NO", "Total fare\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Ticket ticket : allTickets) {
//            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%10s %25s %15s %15s %25s %25s %20s %20s", ticket.getTrainNo(), ticket.getTrainName(), ticket.getDepartureTime(), ticket.getArrivalTime(), ticket.getFrom(), ticket.getTo(), ticket.getPnrNo(), ticket.getTotalfare() + "\n");
//            System.out.println(ticket);
            int pnr = ticket.getPnrNo();
            adminUserModel.getPassenger(pnr);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }
//        System.out.println("------------------------------------------------------------------------------------------------------------------");




    }

    public void showSinglePassenger(Passenger passenger) {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %15s %15s %15s %20s %20s", "Name", "Age", "ID", "Gender","PNR no","Status\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %15s %15s %15s %20s %20s", passenger.getName(), passenger.getAge(), passenger.getId(), passenger.getGender(),passenger.getPnr(), passenger.getStatus() + "\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
}

