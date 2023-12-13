package Classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class User {

    public String name;
    public String response;
    public Rating[] ratings;
    public String[] high_rated_users;
    public String[] low_rated_users;

    public User(JSONObject o){
       this.name = (String) o.get("name");
       this.response = (String) o.get("response");
       this.ratings = fillRatings((JSONArray) o.get("ratings"));
       this.high_rated_users = getHigh_rated_users(ratings);
       this.low_rated_users = getLow_rated_users(ratings);
    }

    private Rating[] fillRatings(JSONArray ratings){
        Rating[] list = new Rating[ratings.size()];
        for(int i = 0; i<ratings.size();i++){
            list[i] = new Rating((JSONObject) ratings.get(i));
        }
        return list;
    }

    private String[] getHigh_rated_users(Rating[] ratings){
        String[] high_rated_users = new String[ratings.length];
        int index = 0;
        for(Rating rating:ratings){
            if(rating.rating >= 3.5){
                high_rated_users[index] = rating.name;
                index++;
            }
        }
        return high_rated_users;
    }

    private String[] getLow_rated_users(Rating[] ratings){
        String[] low_rated_users = new String[ratings.length];
        int index = 0;
        for(Rating rating:ratings){
            if(rating.rating <= 1.5){
                low_rated_users[index] = rating.name;
                index++;
            }
        }
        return low_rated_users;
    }

    public String toString(){
        return "{Name:"+name+", Response:"+response+"}";
    }
}
