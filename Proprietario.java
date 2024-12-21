import java.time.*;
public class Proprietario{
    private String nome;
    private String cognome;
    private String luogoNascita;
    private LocalDate dataNascita;
    private LocalDate scadenzaPatente;
    private Integer giorniScadenzaPatente;
    public Proprietario(String nome, String cognome, String luogoNascita, LocalDate dataNascita,
            LocalDate scadenzaPatente) {
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.scadenzaPatente = scadenzaPatente;
        int y=scadenzaPatente.getYear()-LocalDate.now().getYear();
        giorniScadenzaPatente=(y-1)*365+scadenzaPatente.getDayOfYear()-LocalDate.now().getDayOfYear();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getLuogoNascita() {
        return luogoNascita;
    }
    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
    public LocalDate getScadenzaPatente() {
        return scadenzaPatente;
    }
    public void setScadenzaPatente(LocalDate scadenzaPatente) {
        this.scadenzaPatente = scadenzaPatente;
    }
    public Integer getGiorniScadenzaPatente() {
        return giorniScadenzaPatente;
    }
    
    
}