package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap<String, Integer> {
    private final int capacity;

    public Cache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        Cache cache = new Cache(3);

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        cache.get("A");
        cache.get("C");

        cache.put("D", 4);

        System.out.println("Cache Contents:");
        for (Map.Entry<String, Integer> entry : cache.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
