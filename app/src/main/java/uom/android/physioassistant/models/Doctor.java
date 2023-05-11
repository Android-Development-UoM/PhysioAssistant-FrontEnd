package uom.android.physioassistant.models;

public class Doctor extends User {
    private String afm;
    private String name;
    private String address;

    public Doctor(String name, String address, String afm, String password) {
        super(password);
        this.afm = afm;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "afm='" + afm + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + super.getPassword() + '\'' +
                '}';
    }
}
