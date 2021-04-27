import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class URI2018 {

    public static class Country{
        String name;
        int gold = 0;
        int silver = 0;
        int copper = 0;

        public Country(String name, int type){
            this.name = name;
            this.inserirMedalha(type);
        }
    
        public void inserirMedalha(int type){
            //ouro
            if(type == 1){
                this.gold ++;
            }
            //prata
            else if(type == 2){
                this.silver ++;
            }
            //bronze
            else if(type == 3){
                this.copper ++;
            }
        }

        public int comparaTo(Country c) {
            if (this.gold != c.gold){
                return this.gold > c.gold ? -1 : 1; 
            }
            else if (this.silver != c.silver){
                return this.silver > c.silver ? -1 : 1; 
            }
            else if (this.copper != c.copper){
                return this.copper > c.copper ? -1 : 1; 
            }
            else{
                return this.name.compareTo(c.name);
            }
        }
    }
 
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Map<String, Country> map = new HashMap<String, Country>();

        while (entrada.hasNext()){
            String esporte = entrada.nextLine();

            for (int i = 1; i<=3; i++){
                String countryName = entrada.nextLine();
                if(map.containsKey(countryName)){
                    map.get(countryName).inserirMedalha(i);
                }
                else{
                    map.put(countryName, new Country(countryName, i));
                }
            }
        }

        List<Country> list = new ArrayList<Country>(map.values());

    
        Country temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).comparaTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        System.out.println("Quadro de Medalhas");
        for (Country countries: list){
            System.out.println(countries.name + " " + countries.gold + " " + countries.silver + " " + countries.copper);
         }
    }

}