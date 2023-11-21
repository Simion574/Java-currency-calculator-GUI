import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Main {
    static JLabel ergebnis = new JLabel("Geben Sie Ihren Betrag sowie die Zielwährung ein!");
    static String selectedCurrency;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Währungsrechner");
        frame.setSize(450, 500);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Schließen bei X
        frame.setDefaultLookAndFeelDecorated(true); //Standart Sachen wie Groß


        // iconURL is null when not found
        ImageIcon icon = new ImageIcon("some/package/icon.png");
        frame.setIconImage(icon.getImage());


        JLabel betrag = new JLabel("Betrag");
        betrag.setBounds(50, 25, 100, 30);

        JTextField eingabe = new JTextField("");
        eingabe.setBounds(25, 50, 150, 30);

        JLabel weahrung = new JLabel("Währung");
        weahrung.setBounds(300, 25, 100, 30);

        String comboBoxListe[] = {"Euro", "Dollar", "Yen"};
        JComboBox weahrungAuswahl = new JComboBox<>(comboBoxListe);
        weahrungAuswahl.setBounds(250, 50, 150, 30);

        JLabel ziehlweahrung = new JLabel("Zielwährung");
        ziehlweahrung.setBounds(175, 100, 150, 30);

        JRadioButton EUR = new JRadioButton("Euro");
        EUR.setBounds(175, 125, 150, 30);

        JRadioButton US = new JRadioButton("Dollar");
        US.setBounds(175, 150, 150, 30);

        JRadioButton YEN = new JRadioButton("Yen");
        YEN.setBounds(175,175, 150,30);


        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(EUR);
        gruppe.add(US);
        gruppe.add(YEN);

        EUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCurrency = "EUR";
            }
        });
        US.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCurrency = "US";
            }
        });
        YEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCurrency = "YEN";
            }
        });



        JButton button = new JButton("Umrechen!");
        button.setBounds(125, 210, 200, 30);


        ergebnis.setBounds(75,250,300,30);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textfromEingabe = eingabe.getText();
                    String textfromAuswahl = (String)weahrungAuswahl.getSelectedItem();
                    Double number = Double.parseDouble(textfromEingabe);
                    umrechnung(number, textfromAuswahl, selectedCurrency);
                } catch (Exception error){
                    eingabe.setText("");

                }
            }
        });

        frame.add(YEN);
        frame.add(ziehlweahrung);
        frame.add(EUR);
        frame.add(US);
        frame.add(ergebnis);
        frame.add(button);
        frame.add(weahrungAuswahl);
        frame.add(weahrung);
        frame.add(eingabe);
        frame.add(betrag);
        frame.setLayout(null); //Playzieren von Objekten mit Koordinaten erlauben
        frame.setVisible(true);


        }
        public static void umrechnung(Double number, String waehrung, String finalcurrency){

                //Euro in Euro
            if(waehrung == "Euro" && finalcurrency == "EUR"){
                ergebnis.setBounds(200,250,200,30);
                ergebnis.setText(number + "€");
                //Euro in Dollar
            } else if (waehrung == "Euro" && finalcurrency == "US") {
                double a = number * 1.07;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200,250,200,30);
                ergebnis.setText(roundOFF + "$");
                //Dollar in Dollar
            } else if (waehrung == "Dollar" && finalcurrency == "US") {
                ergebnis.setBounds(200,250,200,30);
                ergebnis.setText(number + "$");
                //Dollar in Euro
            }else if (waehrung == "Dollar" && finalcurrency == "EUR") {
                double a = number * 0.93;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200,250,200,30);
                ergebnis.setText(roundOFF + "€");
                //Yen in Yen
            }else if (waehrung == "Yen" && finalcurrency == "YEN") {
                ergebnis.setBounds(200, 250, 200, 30);
                ergebnis.setText(number + "¥");
                //Euro in Yen
            }else if (waehrung == "Euro" && finalcurrency == "YEN") {
                double a = number * 160.37;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200, 250, 200, 30);
                ergebnis.setText(roundOFF + "¥");
                // Dollar in Yen
            }else if (waehrung == "Dollar" && finalcurrency == "YEN") {
                double a = number * 149.37;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200, 250, 200, 30);
                ergebnis.setText(roundOFF + "¥");
                //Yen in Dollar
            }else if (waehrung == "Yen" && finalcurrency == "US") {
                double a = number * 0.0067;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200, 250, 200, 30);
                ergebnis.setText(roundOFF + "$");
                //Yen in Euro
            }else if (waehrung == "Yen" && finalcurrency == "EUR") {
                double a = number * 0.0062;
                double roundOFF = Math.round(a * 100.0) / 100.0;
                ergebnis.setBounds(200, 250, 200, 30);
                ergebnis.setText(roundOFF + "€");
            }
        }
}