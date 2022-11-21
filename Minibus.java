/*
 *   Minibüs sınıfı minibüsün gişe ücretini, trafik cezasını ve toplam gelecek olan araç sayısını belirtir.
 * */
public class Minibus extends OGSVehicle {
    public Minibus()
    {
        payment = 5;
        ceza = 300;
        RandomVehicle rnd = new RandomVehicle();
        totalVehicle = rnd.randomVehicleMinubus()*8;
    }
}
