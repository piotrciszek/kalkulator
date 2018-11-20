package pl.ciszek.kalkulator.model;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ciszek.kalkulator.manager.KalkulatorManager;

@SpringUI(path = "kalkulator")
public class KalkulatorGui extends UI implements Button.ClickListener{

    @Autowired
    private KalkulatorManager kalkulatorManager;

    private Label display = new Label("0,0");


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        GridLayout layout = new GridLayout(4,5);
        layout.addComponent(display, 0, 0, 3, 0);

        String[] operacje = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", "C", "+"};

        for (String z: operacje) {
            Button button = new Button(z);
            button.addClickListener(this);
            layout.addComponent(button);
        }
        setContent(layout);
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        Button button = clickEvent.getButton();

        char operacja = button.getCaption().charAt(0);

        double wartosc = kalkulatorManager.oblicz(operacja);

        display.setValue(String.valueOf(wartosc));
    }
}
