package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

    public String getPrimeiroNome() {
        return primeiroNome.get();
    }

    public StringProperty primeiroNomeProperty() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome.set(primeiroNome);
    }

    private StringProperty primeiroNome = new SimpleStringProperty(this, "primeiroNome", "");
}
