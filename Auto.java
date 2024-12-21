import java.time.*;
public class Auto {
    private String targa;
    private String modello;
    private LocalTime ingresso;
    private Proprietario propietario;
    public Auto(String targa, String modello, LocalTime ingresso, Proprietario propietario) {
        this.targa = targa;
        this.modello = modello;
        this.ingresso = ingresso;
        this.propietario = propietario;
    }
    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public LocalTime getIngresso() {
        return ingresso;
    }
    public void setIngresso(LocalTime ingresso) {
        this.ingresso = ingresso;
    }
    public Proprietario getPropietario() {
        return propietario;
    }
    public void setPropietario(Proprietario propietario) {
        this.propietario = propietario;
    }
    
    public String toString() {
        return "Auto: targa=" + targa + ", modello=" + modello + ", ingresso=" + ingresso.getHour();
    }
}
