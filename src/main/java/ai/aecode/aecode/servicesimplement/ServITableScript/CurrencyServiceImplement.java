package ai.aecode.aecode.servicesimplement.ServITableScript;

import ai.aecode.aecode.entities.Currency;
import ai.aecode.aecode.repositories.RepoTableScript.ICurrencyRepository;
import ai.aecode.aecode.services.ServTableScript.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImplement implements ICurrencyService {
    @Autowired
    private ICurrencyRepository cR;


    @Override
    public void insert(Currency currency) {
        cR.save(currency);
    }

    @Override
    public List<Currency> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id_currency) {
        cR.deleteById(id_currency);
    }

    @Override
    public Currency listId(int id_currency) {
        return cR.findById(id_currency).orElse(new Currency());
    }
}
