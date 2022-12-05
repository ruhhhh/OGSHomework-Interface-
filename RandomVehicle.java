/**
* Saat başı kaç araç(otobüs, araba, minibüs) geleceğinin hesaplandığı sınıftır.
* */
import java.util.Random;
public class RandomVehicle {
    Random rnd = new Random();
    public int randomVehicleCar()
    {

        int rnd_int1 = rnd.nextInt(40);
        return rnd_int1;
    }
    public int randomVehicleMinubus()
    {

        int rnd_int2 = rnd.nextInt(15);
        return rnd_int2;
    }
    public int randomVehicleBus()
    {

        int rnd_int3 = rnd.nextInt(7);
        return rnd_int3;
    }
}
