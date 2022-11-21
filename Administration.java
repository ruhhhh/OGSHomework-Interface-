/*
* Bu sınıf yönetim amaçlı yazılmıştır. Sınıf toplam ücreti dönmektedir.
* */
public class Administration {
    public String report(Counter g)
    {
        int total = 0 ;

        for ( int i = 0 ;i<g.ogs;i++){

            System.out.println(((OGSVehicle)g.array[i]).toplamUcret);
            total += (((OGSVehicle)g.array[i]).toplamUcret);
        }

        System.out.println("—– n Toplam: " + total);
        String totalTemp = String.valueOf(total);
        return totalTemp;
    }
}

