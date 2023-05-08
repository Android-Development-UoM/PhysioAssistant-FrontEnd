package uom.android.physioassistant.models;

public class Doctor extends User {
    private String afm;

    public Doctor(String name, String address, String afm) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name= " + super.getName() + '\'' +
                "adress= " + super.getAddress() + '\'' +
                "afm='" + afm + '\'' +
                '}';
    }
}
