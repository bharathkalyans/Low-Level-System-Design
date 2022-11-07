public class MyHashMapController {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Bharath");
        map.put(2, "Ananth");
        map.put(3, "Raghu");

        System.out.println(map.get(2));
        System.out.println(map.get(22));
        System.out.println(map.containsKey(1));
    }
}
