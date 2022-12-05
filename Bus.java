/**
* Otobüs sınıfı otobüsün gişe ücretini, trafik cezasını ve toplam gelecek olan araç sayısını belirtir.
* */
public class Bus extends OGSVehicle {

    public Bus()
    {
        payment = 8;
        ceza = 350;
        RandomVehicle rnd = new RandomVehicle();
        totalVehicle = rnd.randomVehicleBus()*8;
    }
}
