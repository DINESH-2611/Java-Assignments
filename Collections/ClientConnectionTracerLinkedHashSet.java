package Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClientConnectionTracerLinkedHashSet {
    private Set<String> clientIds;

    public ClientConnectionTracerLinkedHashSet() {
        clientIds = new LinkedHashSet<>();
    }
    public void trackConnection(String clientId) {
        clientIds.add(clientId);
    }
    public void displayConnectionOrder() {
        System.out.println("Client Connection Order:");
        for (String clientId : clientIds) {
            System.out.println(clientId);
        }
    }

    public static void main(String[] args) {
        ClientConnectionTracerLinkedHashSet tracker = new ClientConnectionTracerLinkedHashSet();
        tracker.trackConnection("client1");
        tracker.trackConnection("client2");
        tracker.trackConnection("client3");
        tracker.trackConnection("client1");
        tracker.trackConnection("client4");
        tracker.displayConnectionOrder();
    }
}
