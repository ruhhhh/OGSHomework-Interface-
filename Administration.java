/**
* Bu sınıf yönetim amaçlı yazılmıştır. Sınıf toplam ücreti dönmektedir.
* */
public class Administration {
    public String report(Counter gise)
    {
        int total = 0 ;

        for ( int i = 0 ;i<gise.ogs;i++){

            System.out.println(((OGSVehicle)gise.array[i]).toplamUcret);
            total += (((OGSVehicle)gise.array[i]).toplamUcret);
        }

        System.out.println("—– n Toplam: " + total);
        String totalTemp = String.valueOf(total);
        return totalTemp;
    }
}

