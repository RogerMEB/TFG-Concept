package Classes;

import org.json.simple.JSONObject;

public class Rating {

    public String name;
    public double rating;

    public Rating(JSONObject rating){
        this.name = (String) rating.get("name");
        this.rating = (double) rating.get("rating");
    }

}
