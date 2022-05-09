public class Doctor extends Staff{
    private String specializare;
    private String grad;

    public Doctor(String nume, String prenume, String telefon, String email, Integer salariu, String specializare, String grad) {
        super(nume, prenume, telefon, email, salariu);
        this.specializare = specializare;
        this.grad = grad;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Nume='" + getNume() + '\'' +
                ", Prenume='" + getPrenume() + '\'' +
                ", Telefon='" + getTelefon() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Salariu=" + getSalariu() +
                ", Specializare='" + specializare + '\'' +
                ", Grad='" + grad + '\'' +
                '}';
    }
}
