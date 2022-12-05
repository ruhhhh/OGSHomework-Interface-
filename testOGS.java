/**
* Swing uygulamasından önce ana hatlarıyla mantığın çalışıp çalışmadığını kontrol etmek amacıyla bu sınıf kullanılır.
* */
public class testOGS {
    public static void main(String[] args)
    {
        Minibus minibus = new Minibus();
        minibus.balance = 100;
        Counter counter = new Counter();
        counter.getPaid(minibus);
        Car car = new Car();
        car.balance = 70;
        counter.getPaid(car);
        counter.getPaid(minibus);
        Administration admin = new Administration();
        admin.report(counter);
        System.out.println(minibus.balance);

    }

}