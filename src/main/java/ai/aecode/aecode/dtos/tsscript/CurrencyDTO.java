package ai.aecode.aecode.dtos.tsscript;

import jakarta.persistence.Column;

public class CurrencyDTO {
    private int id_currency;
    private String currency_name;

    public int getId_currency() {
        return id_currency;
    }

    public void setId_currency(int id_currency) {
        this.id_currency = id_currency;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }
}
