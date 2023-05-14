package uom.android.physioassistant.models;

public class Doctor extends User {
    private String afm;
    private String name;
    private String address;

    public Doctor(String name, String address, String afm, String username, String password) {
        super(username, password);
        this.afm = afm;
        this.name = name;
        this.address = address;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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
