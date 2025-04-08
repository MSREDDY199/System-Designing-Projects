import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add (100);
//        list.add (150);
//        list.add (15);
//        list.add (200);
//        list.add (300);
//        list.add (400);
//        list.add (500);
//
//        for (int i = 0; i<list.size(); i++) {
//            char c = list.get(i).toString().charAt(0);
//            if (c == '1') {
//                System.out.println(list.get(i));
//            }
//        }

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "a");
        map.put("5", "b");
        map.put("6", "c");
        map.put("7", "d");

        Map<String, List<String>> list = new HashMap<>();

        for (Map.en) {
            list.putIfAbsent(map.get(str), new ArrayList<>());
            list.get(str).add(str);
        }

        System.out.println(list);
    }
}