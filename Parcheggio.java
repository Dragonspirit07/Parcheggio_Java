import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class Parcheggio {
    private String nome;
    private Integer capienza;
    private ArrayList<Auto> auto;
    public Parcheggio(String nome, Integer capienza, ArrayList<Auto> auto) {
        this.nome = nome;
        this.capienza = capienza;
        this.auto = auto;
    }
    public Parcheggio(String nome, Integer capienza) {
        this.nome = nome;
        this.capienza = capienza;
        auto= new ArrayList<Auto>();
    }
    public void addAuto(Auto a){
        if(capienza>auto.size() && a.getPropietario().getGiorniScadenzaPatente()>=0){
            auto.add(a);
        }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCapienza() {
        return capienza;
    }
    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }
    public ArrayList<Auto> getAuto() {
        return auto;
    }
    public void setAuto(ArrayList<Auto> auto) {
        this.auto = auto;
    }
    public Integer uscitaAuto(String tg){
        for(Auto a: auto){
            if(a.getTarga()==tg){
                auto.remove(a);
                if(LocalTime.now().getHour()-a.getIngresso().getHour()==0){
                    return 1;
                } 
                else{
                    if(LocalTime.now().getMinute()>a.getIngresso().getMinute()){
                        if(LocalTime.now().getHour()-a.getIngresso().getHour()+1>9){
                            return 10;
                        }
                        else{
                            return LocalTime.now().getHour()-a.getIngresso().getHour()+1;
                        }
                    }
                    else{
                        if(LocalTime.now().getHour()-a.getIngresso().getHour()+1>9){
                            return 10;
                        }
                        return LocalTime.now().getHour()-a.getIngresso().getHour();
                    }
                }
            }
        }
        return -1;
    }
    public String statoParcheggio(){
        return "Posti liberi: "+(capienza-auto.size())+", Posti occupati: "+auto.size();
    }
    
    public String toString() {
        String tmp="";
        tmp+="nome=" + nome + ", capienza=" + capienza + ",\n";
        for (int i=0;i<auto.size();i++){
            tmp+=auto.get(i).toString();
            if(i!=auto.size()-1){
                tmp+="\n";
            }
        }
        return tmp;
    }
    public static void main(String[] args) {
        Proprietario p1=new Proprietario("Matteo", "Rossi", "Parma", LocalDate.of(2007, 1, 29), LocalDate.of(2026, 3, 15));
        Auto a1=new Auto("AB123CD", "Opel", LocalTime.of(3, 0), p1);
        Parcheggio par1= new Parcheggio("par1", 50);
        par1.addAuto(a1);
        System.out.println(par1.statoParcheggio());
        System.out.println(par1.toString());
        System.out.println(par1.uscitaAuto("AB123CD"));
        
    }
}
