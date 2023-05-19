package uom.android.physioassistant.models;

public class PhysioAction {

    private String code;
    private String name;
    private String description;
    private double cost;

    public PhysioAction(String code, String name, String description, double cost) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
}
