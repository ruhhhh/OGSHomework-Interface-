/*
* Saat başı kaç araç(otobüs, araba, minibüs) geleceğinin hesaplandığı sınıftır.
* */
import java.util.Random;
public class RandomVehicle {
    public int randomVehicleCar()
    {
        Random rnd = new Random();
        int rnd_int1 = rnd.nextInt(40);
        return rnd_int1;
    }
    public int randomVehicleMinubus()
    {
        Random rnd = new Random();
        int rnd_int2 = rnd.nextInt(15);
        return rnd_int2;
    }
    public int randomVehicleBus()
    {
        Random rnd = new Random();
        int rnd_int3 = rnd.nextInt(7);
        return rnd_int3;
    }
}
