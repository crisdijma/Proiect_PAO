public class Doctor extends Staff{
    private String Specializare;
    private String Grad;

    public Doctor(String nume, String prenume, String telefon, String email, Integer salariu, String specializare, String grad) {
        super(nume, prenume, telefon, email, salariu);
        Specializare = specializare;
        Grad = grad;
    }

    public String getSpecializare() {
        return Specializare;
    }

    public void setSpecializare(String specializare) {
        Specializare = specializare;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String grad) {
        Grad = grad;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Specializare='" + Specializare + '\'' +
                ", Grad='" + Grad + '\'' +
                '}';
    }
}
