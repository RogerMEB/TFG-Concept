package Classes;

import java.util.ArrayList;

public class Group {

    public ArrayList<User> users_list;

    public void setUsers_list(ArrayList<User> users_list) {
        this.users_list = users_list;
    }

    public double getDiscrepancy(){
        double sum = 0;
        int aux = 0;
        for(int i = 0; i< users_list.size(); i++){
            for(int j = 0; j < users_list.size()-aux; j++){
                sum += computeMSE(users_list.get(i).ratings,users_list.get(j + aux).ratings);
            }
            aux ++;
        }
        return sum;
    }

    public ArrayList<ArrayList<User>> getOposedUsers(){
        ArrayList<ArrayList<User>> oposed_users = new ArrayList<>();
        for(int i=0; i<users_list.size()-1; i++){
            for(int j=i+1; j<users_list.size();j++){
                ArrayList<User> aux = new ArrayList<>();
                double discrepancy = computeMSE(users_list.get(i).ratings, users_list.get(j).ratings);
                if (discrepancy >= 5) {
                    aux.add(users_list.get(i));
                    aux.add(users_list.get(j));
                    oposed_users.add(aux);
                }
            }
        }
        return oposed_users;
    }

    public ArrayList<ArrayList<User>> getSimilarUsers(){
        ArrayList<ArrayList<User>> oposed_users = new ArrayList<>();
        for(int i=0; i<users_list.size()-1; i++){
            for(int j=i+1; j<users_list.size();j++){
                ArrayList<User> aux = new ArrayList<>();
                double discrepancy = computeMSE(users_list.get(i).ratings, users_list.get(j).ratings);
                if (discrepancy <= 1) {
                    aux.add(users_list.get(i));
                    aux.add(users_list.get(j));
                    oposed_users.add(aux);
                }
            }
        }
        return oposed_users;
    }

    private double computeMSE(Rating[] a, Rating[] b){
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++){
                if(a[i].name.equals(b[j].name) && a[i].name != null && b[i].name != null){
                    double diff = a[i].rating - b[j].rating;
                    sum = sum + diff * diff;
                }
            }
        }
        return sum / a.length;
    }

}
