import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok=0;
        this.letrejott=LocalDateTime.now();
        this.szerkesztve=this.letrejott;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom= tartalom;
        this.szerkesztve=LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like(){
        this.likeok+=1;
    }

    @Override
    public String toString() {
        if(szerkesztve==letrejott){
            return String.format("%s-%d-%tF %tT\n%s", szerzo, likeok, letrejott, letrejott, tartalom);
        }else {
            return String.format("%s-%d-%tF %tT\nSzerkesztve:%tF %tT\n%s", szerzo, likeok, letrejott, letrejott, szerkesztve, szerkesztve, tartalom);
        }
    }
}
