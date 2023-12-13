import Classes.Group;
import Classes.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {
            JSONArray data = (JSONArray) parser.parse(new FileReader("./src/main/resources/Data.txt"));
            Group group = new Group();
            ArrayList<User> list = new ArrayList<>();
            for (Object obj : data) {
                User user = new User((JSONObject) obj);
                System.out.println(user.toString());
                System.out.println(Arrays.toString(user.high_rated_users));
                System.out.println(Arrays.toString(user.low_rated_users));
                list.add(user);
            }
            group.setUsers_list(list);
            System.out.println("Discrepancy of ratings inside the group:" + group.getDiscrepancy());
            System.out.println(group.getOposedUsers());
            System.out.println(group.getSimilarUsers());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
