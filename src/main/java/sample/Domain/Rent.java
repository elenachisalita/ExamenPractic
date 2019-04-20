package sample.Domain;

public class Rent extends Entity {

    private String idRent;
    private String numberOfDays;
    private String usedKm;

    public Rent(String id, String idRent, String numberOfDays, String usedKm) {
        super(id);
        this.idRent = idRent;
        this.numberOfDays = numberOfDays;
        this.usedKm = usedKm;
    }

    public String getIdRent() {
        return idRent;
    }

    public void setIdRent(String idRent) {
        this.idRent = idRent;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getUsedKm() {
        return usedKm;
    }

    public void setUsedKm(String usedKm) {
        this.usedKm = usedKm;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "idRent='" + idRent + '\'' +
                ", numberOfDays='" + numberOfDays + '\'' +
                ", usedKm='" + usedKm + '\'' +
                '}';
    }
}
