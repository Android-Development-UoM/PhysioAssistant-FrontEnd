package uom.android.physioassistant.models;

import java.io.Serializable;

public class PhysioAction implements Serializable {

    private String code;
    private String name;
    private String description;
    private double costPerSession;

    public PhysioAction(String code, String name, String description, double costPerSession) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.costPerSession = costPerSession;
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

    public double getCostPerSession() {
        return costPerSession;
    }
    public void setCostPerSession(double costPerSession) {
        this.costPerSession = costPerSession;
    }
}
