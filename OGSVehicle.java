/*
* OGS'ye sahip araçların ödemelerinin alındığı ve cezalarının yansıtıldığı sınıfır.
* */

import java.util.Random;
public class OGSVehicle implements OGSIsHave {
    int balance;
    int balanceTemp;
    int payment;
    int totalVehicle;
    int toplamUcret;
    String plateString;
    int ceza;
    @Override
    public int payment() {
        Random rnd = new Random();
        balanceTemp = rnd.nextInt(-1,1000);
        balance = balanceTemp - payment;
        return balance;
    }
     public String[] plateMaking() {
         Random rastgele = new Random();
         String alphabet = "ABCDEFGHIJKLMNOPRSTUVYZ";
         String [] plateArray = new String[totalVehicle];
         for (int i = 0; i < totalVehicle; i++) {
             plateString =rastgele.nextInt(1,99) + " "
                    + alphabet.charAt(rastgele.nextInt(alphabet.length())) + alphabet.charAt(rastgele.nextInt(alphabet.length()))
                    + " " + rastgele.nextInt(100,999);

            System.out.println(plateString);
             plateArray[i] = plateString;
        }
       return plateArray.clone();
     }

    @Override
    public int totalCharge() {
        toplamUcret = totalVehicle*payment;
        return toplamUcret;
    }

    @Override
    public int ceza() {
        return ceza;
    }
}
