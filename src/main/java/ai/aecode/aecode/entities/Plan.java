package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_plan;
    @Column (name="plan_name", length = 30, nullable = false)
    private String plan_name;
    @Column (name="plan_description", length = 30, nullable = false)
    private String plan_description;
    @Column (name="plan_price", nullable = false)
    private double plan_price;

    public Plan() {
    }

    public Plan(int id_plan, String plan_name, String plan_description, double plan_price) {
        this.id_plan = id_plan;
        this.plan_name = plan_name;
        this.plan_description = plan_description;
        this.plan_price = plan_price;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int int_plan) {
        this.id_plan = int_plan;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public double getPlan_price() {
        return plan_price;
    }

    public void setPlan_price(double plan_price) {
        this.plan_price = plan_price;
    }
}
