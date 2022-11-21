/*
* Hatayı yakalayan ve ekrana sınıftan dönen mesajı yazan sınıftır.
* */
public class OGSHaveNot extends Exception{

     public String getMessage()
     {
         return "Bu aracın OGS Cihazı yoktur.";
     }
}
