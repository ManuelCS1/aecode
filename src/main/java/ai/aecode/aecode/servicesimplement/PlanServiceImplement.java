package ai.aecode.aecode.servicesimplement;
import ai.aecode.aecode.entities.Plan;
import ai.aecode.aecode.repositories.IPlanRepository;
import ai.aecode.aecode.services.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanServiceImplement implements IPlanService {
    @Autowired
    private IPlanRepository pR;

    @Override
    public void insert(Plan plan) {
        pR.save(plan);
    }

    @Override
    public List<Plan> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int id_plan) {
        pR.deleteById(id_plan);
    }

    @Override
    public Plan listId(int id_plan) {
        return pR.findById(id_plan).orElse(new Plan());
    }
}
