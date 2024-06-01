package ai.aecode.aecode.services.ServTableScript;
import ai.aecode.aecode.entities.Currency;
import java.util.List;

public interface ICurrencyService {
    public void insert(Currency currency);
    List<Currency> list();
    public void delete(int id_currency);
    public Currency listId(int id_currency);
}
