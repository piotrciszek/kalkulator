package pl.ciszek.kalkulator.manager;

import org.springframework.stereotype.Service;

@Service
public class KalkulatorManager {

    private double liczbaWyswietlana = 0.0;
    private double liczbaWPamieci = 0.0;
    private char operacja;


    public double oblicz(char znak) {

        switch (operacja) {
            case '+':
                liczbaWPamieci += liczbaWyswietlana;
                break;
            case '-':
                liczbaWPamieci -= liczbaWyswietlana;
                break;
            case '/':
                liczbaWPamieci /= liczbaWyswietlana;
                break;
            case '*':
                liczbaWPamieci *= liczbaWyswietlana;
                break;
            case 'C':
                liczbaWPamieci = liczbaWyswietlana;
                break;
        }
        operacja = znak;
        liczbaWyswietlana = 0.0;
        if (znak == 'C'){
            liczbaWPamieci = 0.0;
        }
        return liczbaWPamieci;
    }
}
