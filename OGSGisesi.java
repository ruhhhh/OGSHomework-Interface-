/*
* Gişe görevlisinin 8 saatlik mesaiye başlayıp araçları okuttuğu ve raporladığı alandır.
* Araçlar ekrana basılırken OGS'den geçtikten sonra OGS Cihazlarının olup olmadığına ilişkin Execption kontrolü yapılır.
* Bu alan Swing ile yapılmıştır.
* İçerisinde 2 adet TextPane ve 1 adet JTable kullanılmıştır. Ayrıca uygulamayı koşturmak için başla ve bitir butonları kullanılmıştır.
* */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OGSGisesi {
    private JButton button1;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton mesaiyiBitirButton;
    private JTextArea textArea2;
    private JTable table1;
    int sayacOGSYok=0;
    int sayacBakiyeYetersiz=0;
    public OGSGisesi() {
        button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = new Car();
                Minibus minibus = new Minibus();
                Bus bus = new Bus();
                textArea1.setText("Günlük mesai başladı. Kalan mesai saati 8 saattir.\n\n" +
                        "1 saatte gelecek araç sayısı: " +  car.totalVehicle/8 +
                        "\n1 saatte gelecek minibüs sayısı: " + minibus.totalVehicle/8 +
                        "\n1 saatte gelecek otobüs sayısı: " + bus.totalVehicle/8 +
                        "\n\nToplam gelecek araç sayısı: " +  car.totalVehicle +
                        "\nToplam gelecek minibüs sayısı: " + minibus.totalVehicle +
                        "\nToplam gelecek otobüs sayısı: " + bus.totalVehicle +
                        "\n\nAraç başına alınan ücret: " + car.payment + " TL" +
                        "\nMinibüs başına alınan ücret: " + minibus.payment + " TL" +
                        "\nOtobüs başına alınan ücret: " + bus.payment + " TL"
                );
                Counter counter = new Counter();
                Administration admin = new Administration();
                counter.getPaid(car);
                counter.getPaid(minibus);
                counter.getPaid(bus);
                counter.totalPayCalculation(car);
                counter.totalPayCalculation(minibus);
                counter.totalPayCalculation(bus);

                DefaultTableModel model = new DefaultTableModel();
                table1.setModel(model);
                model.addColumn("Araç Plakaları");
                model.addColumn("Araç Türü");
                model.addColumn("Araç Sınıfı");
                model.addColumn("Kalan Bakiye");
                model.addColumn("OGS Cihazı");
                model.addColumn("Ceza");

                ExecptionThrow execptionThrow = new ExecptionThrow();
                String [] otomobilDizi = car.plateMaking();
                for(String wordOtomobil: otomobilDizi)
                {
                        car.payment();
                        if (car.balanceTemp == -1) {
                            try
                            {
                                execptionThrow.Execption();
                            }
                            catch (OGSHaveNot hata)
                            {
                                System.out.print(" " + hata.getMessage());
                            }
                            model.addRow(new Object[]{wordOtomobil, "Otomobil", "1. Sınıf Araç", "-", "OGS Cihazı Yok", car.ceza()*2+" TL"});
                            sayacOGSYok++;
                        }
                        else if (car.balance<0) {
                            model.addRow(new Object[]{wordOtomobil, "Otomobil", "1. Sınıf Araç", car.balance, "Bakiye Yetersiz.", car.ceza+" TL"});
                            sayacBakiyeYetersiz++;
                        } else {
                            model.addRow(new Object[]{wordOtomobil, "Otomobil", "1. Sınıf Araç", car.balance + " TL", "Uygun"});

                        }
                    }

                String [] minibusDizi = minibus.plateMaking();
                for(String wordMinibus: minibusDizi)
                {
                    minibus.payment();
                    if(minibus.balanceTemp == -1)
                    {
                        try
                        {
                            execptionThrow.Execption();
                        }
                        catch (OGSHaveNot hata)
                        {
                            System.out.print(" " + hata.getMessage());
                        }
                        model.addRow(new Object[]{wordMinibus, "Minibüs", "2. Sınıf Araç", "-", "OGS Cihazı Yok", minibus.ceza()*2+" TL"});
                        sayacOGSYok++;
                    } else if (minibus.balance<0) {
                        model.addRow(new Object[]{wordMinibus, "Minibüs", "2. Sınıf Araç", minibus.balance, "Bakiye Yetersiz.", minibus.ceza+" TL"});
                        sayacBakiyeYetersiz++;
                    }
                    else {
                        model.addRow(new Object[]{wordMinibus, "Minibüs", "2. Sınıf Araç", minibus.balance + " TL", "Uygun"});
                    }
                }

                String [] otobusDizi = bus.plateMaking();
                for(String wordOtobus: otobusDizi)
                {
                    bus.payment();
                    if(bus.balanceTemp == -1)
                    {
                        try
                        {
                            execptionThrow.Execption();
                        }
                        catch (OGSHaveNot hata)
                        {
                            System.out.print(" " + hata.getMessage());
                        }
                        model.addRow(new Object[]{wordOtobus, "Otobüs", "3. Sınıf Araç", "-", "OGS Cihazı Yok", bus.ceza()*2+" TL"});
                        sayacOGSYok++;
                    } else if (minibus.balance<0) {
                        model.addRow(new Object[]{wordOtobus, "Otobüs", "3. Sınıf Araç", bus.balance, "Bakiye Yetersiz.", bus.ceza+" TL"});
                        sayacBakiyeYetersiz++;
                    }
                    else {
                        model.addRow(new Object[]{wordOtobus, "Otobüs", "3. Sınıf Araç", bus.balance + " TL", "Uygun"});
                    }
                }

                textArea2.setText("Toplam gelen " + (minibus.totalVehicle+ car.totalVehicle+ bus.totalVehicle) + " araç için kazanılan para: " + admin.report(counter)+ " TL"+
                        "\nOGS olmayan Araç-Minibüs-Otobüs sayısı: " + sayacOGSYok + " Tahsil edilen ceza tutarı: " + (sayacOGSYok* car.ceza()+ sayacOGSYok*minibus.ceza() + sayacOGSYok* bus.ceza())*2 +
                        "\nYetersiz bakiyesi olan Araç-Minibüs-Otobüs sayısı: " + sayacBakiyeYetersiz + " Tahsil edilen ceza tutarı: " + (sayacBakiyeYetersiz* car.ceza()+sayacBakiyeYetersiz* minibus.ceza()+ sayacBakiyeYetersiz* bus.ceza()));

            }
        });
        mesaiyiBitirButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OGS Gisesi");
        frame.setContentPane(new OGSGisesi().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
}
