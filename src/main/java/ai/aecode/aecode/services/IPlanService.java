package ai.aecode.aecode.services;
import ai.aecode.aecode.entities.Plan;

import java.util.List;

public interface IPlanService {
    public void insert(Plan plan);
    List<Plan> list();
    public void delete(int id_plan);
    public Plan listId(int id_plan);
}
