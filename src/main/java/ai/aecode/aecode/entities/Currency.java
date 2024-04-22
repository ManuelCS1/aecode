package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_currency;
    @Column (name="currency_name", length = 30, nullable = false)
    private String currency_name;

    public Currency() {
    }

    public Currency(int id_currency, String currency_name) {
        this.id_currency = id_currency;
        this.currency_name = currency_name;
    }

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
