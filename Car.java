/**
 *  Araba sınıfı arabanın gişe ücretini, trafik cezasını ve toplam gelecek olan araç sayısını belirtir.
 * */
public class Car extends OGSVehicle {
    public Car()
    {
        payment = 3;
        ceza = 250;
        RandomVehicle rnd = new RandomVehicle();
        totalVehicle = rnd.randomVehicleCar()*8;
    }
}
