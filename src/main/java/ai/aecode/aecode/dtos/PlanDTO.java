package ai.aecode.aecode.dtos;

import jakarta.persistence.Column;

public class PlanDTO {
    private int id_plan;
    private String plan_name;
    private String plan_description;
    private double plan_price;

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
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
