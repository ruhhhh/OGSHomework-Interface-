/*
* Gişe sınıfı ödeme alan ve toplam ödemeyi hesaplayan sınıftır. Counter metodu ile istenirse manüel olarak araç eklemeye olanak sağlar.
* */
public class Counter {
    OGSIsHave[] array;
    int ogs;
    public Counter()
    {
        array = new OGSIsHave[20];
        ogs = 0;
    }
    public void getPaid(OGSIsHave ogsIsHave)
    {
        array[ogs++] = ogsIsHave;
        ogsIsHave.payment();
        //ogsBulundurur.toplamUcret();
    }
    public void totalPayCalculation(OGSIsHave ogsIsHave)
    {
        array[ogs++] = ogsIsHave;
        ogsIsHave.totalCharge();
    }
}
