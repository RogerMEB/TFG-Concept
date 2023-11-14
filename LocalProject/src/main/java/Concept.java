import java.util.ArrayList;

public class Concept{

    public static void main(String[] args) {
        mainCaller();
    }
    public static Integer[][] similarity_calculation(Integer[][] args){

        Integer[][] difference = new Integer[args.length][args.length];
        System.out.println(difference);
        int counter = 0;

        for (int i = counter; i<args.length; i++){
            for(int k = counter+1; k<args.length; k++ ){
                int sum = 0;
                for (int j = 0; j < args[0].length; j++) {
                    if(i != j && j != k) {
                        sum += Math.abs(args[i][j] - args[k][j]);
                    }
                }
                difference[k][i] = difference[i][k] = sum;
            }

            counter++;
        }

        return difference;
    }

    public static ArrayList<ArrayList> getGroups_Similarity(Integer[][] differences){
        ArrayList<ArrayList> groups = new ArrayList();

        for(int i =0; i < differences.length; i++){
            ArrayList row_group = new ArrayList();
            row_group.add(i);
            for(int j = 0; j < differences.length;j++){

                if(differences[i][j]!=null && differences[i][j] <=1) {
                        row_group.add(j);
                }
            }
            groups.add(row_group);
        }
        return groups;
    }

    public static ArrayList<ArrayList> getGroups_Oposed(Integer[][] differences){
        ArrayList<ArrayList> groups = new ArrayList();

        for(int i =0; i < differences.length; i++){
            ArrayList row_group = new ArrayList();
            row_group.add(i);
            for(int j = 0; j < differences.length;j++){

                if(differences[i][j]!=null && differences[i][j] >=5) {
                    row_group.add(j);
                }
            }
            groups.add(row_group);
        }

        return groups;
    }

    public static void getInfo(Integer[][] differences){

        double[] individual_discrepancy = new double[differences.length];
        double group_discrepancy = 0;

        double expected_mean = Math.pow(differences.length-1,2)*7.5;

        for(int i = 0; i<differences.length; i++){
            individual_discrepancy[i] = sum(differences[i]);
            System.out.println("Usuario " + i + " tiene el siguiente nivel de discrepancia según sus valoraciones:" + individual_discrepancy[i]);
            group_discrepancy += individual_discrepancy[i];
        }

        System.out.println("Discrepancia media de un grupo:" + expected_mean);
        System.out.println("Discrepancia del grupo:" + group_discrepancy);

    }


    static void mainCaller(){
        Integer[][] valoracion = {{null,4,5},{3,null,0},{0,4,null},{1,1,5},{2,3,0}};
        Integer[][] result = similarity_calculation(valoracion);
        System.out.println(result);
        ArrayList groups_similarity = getGroups_Similarity(result);
        System.out.println(groups_similarity);
        ArrayList groups_difference = getGroups_Oposed(result);
        System.out.println(groups_difference);
        getInfo(result);


    }

    static Integer sum(Integer[] lista ){
        int sum = 0;
        for(int i = 0; i< lista.length; i++){
            if(lista[i] != null){
                sum += lista[i];
            }
        }
        return sum;
    }


}
