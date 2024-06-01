package datalayer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TrainBookingDatabse {
    private String appName;
    private static TrainBookingDatabse trainBookingDatabse;
    private List<TrainRoutes> trainRoutesList = new ArrayList<>();
    private List<Passenger> passengerList = new ArrayList<>();
    private List<Credential> credentialList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public static TrainBookingDatabse getInstance() {
        if (trainBookingDatabse == null) {
            trainBookingDatabse = new TrainBookingDatabse();
        }
        return trainBookingDatabse;
    }

    public String getAppName() {
        return appName;
    }

    public void createCredentails() {
        if (credentialList.isEmpty()) {
            Credential credential = new Credential();
            credential.setUserName("zsgs");
            credential.setPassword("admin");
            credential.setRole(1);
            credentialList.add(credential);
        }
        appName = "IRCTC";
    }

    public boolean isUserExist(String userName, String password) {
        for (Credential credential : credentialList) {
            if (credential.getUserName().equals(userName))
                return false;
        }
        return true;
    }

    public void adduser(String userName, String password) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        userList.add(user);
        Credential credential = new Credential();
        credential.setUserName(userName);
        credential.setPassword(password);
        credentialList.add(credential);
    }

    public void addTrainroutes(TrainRoutes trainRoutes) {
        trainRoutesList.add(trainRoutes);
    }

    public List<TrainRoutes> getAvailabletrains(String from, String to) {
        int start=-1,end=-1;
        List<TrainRoutes> availabletrains = new ArrayList<>();
        for (TrainRoutes trainRoutes : trainRoutesList) {
            List<String> routes = trainRoutes.getRoutes();
            for (int i = 0; i <routes.size() ; i++) {
                if(routes.get(i).equalsIgnoreCase(from))
                    start=i;
                if(routes.get(i).equalsIgnoreCase(to))
                    end=i;
            }
//            if (routes.get(0).equalsIgnoreCase(from) && routes.get(routes.size() - 1).equalsIgnoreCase(to))
//                availabletrains.add(trainRoutes);
            if(start!=-1 && end!=-1 && start<end)
                availabletrains.add(trainRoutes);
        }
        return availabletrains;
    }

    public boolean validuser(String userName, String password) {
        for (Credential credential : credentialList) {
            if (credential.getUserName().equals(userName) && credential.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public List<TrainRoutes> getAllTrains() {
        return trainRoutesList;
    }

    public Ticket getPnr(int pnr) {
        for (Ticket ticket : ticketList) {
            if (ticket.getPnrNo() == pnr)
                return ticket;
        }
        return null;
    }

    public List<Passenger> getPassengersByPnr(int pnr) {
        List<Passenger> passengers = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            if (passenger.getPnr() == pnr)
                passengers.add(passenger);
        }
        return passengers;
    }

    public List<Ticket> getTickets() {
        return ticketList;
    }

    public List<Passenger> getpassengers() {
        return passengerList;
    }

    public List<Ticket> getTicketsByPnr(int pnr) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (ticket.getPnrNo() == pnr)
                tickets.add(ticket);
        }
        return tickets;
    }

    public void addPassengers(Passenger[] passengers1, int pnr) {
        for (Passenger passenger : passengers1) {
            passenger.setPnr(pnr);
            passengerList.add(passenger);
        }
    }

    public void addTicket(TrainRoutes trainRoutes, int pnr, String from, String to, int totalfare) {
        Ticket ticket = new Ticket();
        ticket.setTrainNo(trainRoutes.getTrainNo());
        ticket.setTrainName(trainRoutes.getTrainName());
        ticket.setDepartureTime(trainRoutes.getDepartureTime());
        ticket.setArrivalTime(trainRoutes.getArrivalTime());
        ticket.setFrom(from);
        ticket.setTo(to);
        ticket.setPnrNo(pnr);
        ticket.setTotalfare(totalfare);
        ticketList.add(ticket);
    }

    public void getPnrToUser(String userName, int pnr) {
        for (User user : userList) {
            if (user.getName().equals(userName))
                user.setPnr(pnr);
        }
    }

    public int getPnrNo(String userName) {
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                return user.getPnr();
            }
        }
        return -1;
    }

    public void removeTicket(Ticket ticket) {
        Ticket ticket2 = null;
        for (Ticket ticket1 : ticketList) {
            if (ticket.getPnrNo() == ticket1.getPnrNo())
                ticket2 = ticket1;
        }
        ticketList.remove(ticket2);
    }

    public Passenger getPassenger(int id) {
        for (Passenger passenger : passengerList) {
            if (passenger.getId() == id)
                return passenger;
        }
        return null;
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }
    private void saveUsers() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(userList);

        try (FileWriter writer = new FileWriter("/Users/zsgs-mac1/Dbfiles/User.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveTickets() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(ticketList);

        try (FileWriter writer = new FileWriter("/Users/zsgs-mac1/Dbfiles/Ticket.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveTrainRoutes() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(trainRoutesList);

        try (FileWriter writer = new FileWriter("/Users/zsgs-mac1/Dbfiles/TrainRoutes.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveCredential() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(credentialList);

        try (FileWriter writer = new FileWriter("/Users/zsgs-mac1/Dbfiles/Credential.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void savePassenger() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(passengerList);

        try (FileWriter writer = new FileWriter("/Users/zsgs-mac1/Dbfiles/Passenger.json")) {
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<User> loadUsers()  {
        Gson gson = new Gson();
        List<User> loadedList = new ArrayList<>();
        try {
            File file=new File("/Users/zsgs-mac1/Dbfiles/User.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        try (
                FileReader reader = new FileReader("/Users/zsgs-mac1/Dbfiles/User.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<User>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private List<Ticket> loadTicket()  {
        Gson gson = new Gson();
        List<Ticket> loadedList = new ArrayList<>();
        try {
            File file=new File("/Users/zsgs-mac1/Dbfiles/Ticket.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        try (
                FileReader reader = new FileReader("/Users/zsgs-mac1/Dbfiles/User.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Ticket>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private List<TrainRoutes> loadTrainRoutes()  {
        Gson gson = new Gson();
        List<TrainRoutes> loadedList = new ArrayList<>();
        try {
            File file=new File("/Users/zsgs-mac1/Dbfiles/TrainRoutes.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        try (
                FileReader reader = new FileReader("/Users/zsgs-mac1/Dbfiles/TrainRoutes.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<TrainRoutes>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private List<Credential> loadCredential()  {
        Gson gson = new Gson();
        List<Credential> loadedList = new ArrayList<>();
        try {
            File file=new File("C:\\Users\\zoho\\Dbfiles\\Library\\Credential.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        try (
                FileReader reader = new FileReader("/Users/zsgs-mac1/Dbfiles/Credential.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Credential>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;


    }
    private List<Passenger> loadPassenger()  {
        Gson gson = new Gson();
        List<Passenger> loadedList = new ArrayList<>();
        try {
            File file=new File("/Users/zsgs-mac1/Dbfiles/Passenger.json");
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        try (
                FileReader reader = new FileReader("/Users/zsgs-mac1/Dbfiles/Passenger.json")) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            String jsonString = sb.toString();
            if (jsonString.isEmpty()) {
                return loadedList;
            }

            Type type = new TypeToken<List<Passenger>>() {
            }.getType();
            loadedList = gson.fromJson(jsonString, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedList;
    }

    public void loadAll(){
        this.userList=loadUsers();
        this.ticketList=loadTicket();
        this.trainRoutesList=loadTrainRoutes();
        this.credentialList=loadCredential();
        this.passengerList=loadPassenger();
    }
    public void saveAll(){
        saveUsers();
        saveTickets();
        saveTrainRoutes();
        saveCredential();
        savePassenger();
    }
}
