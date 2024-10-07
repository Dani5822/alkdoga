import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class feladatok {
    Random r=new Random();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Bejegyzes> bejegyzesek=new ArrayList<Bejegyzes>();
    public void Kezdet(){
        bejegyzesek.add((new Bejegyzes("Dani","Nem tudom.")));
        bejegyzesek.add((new Bejegyzes("Józsi","Ő sem tudja.")));
    }

    public void bejegyzeshozzaadas(){
        System.out.print("Kérek egy számot:");
        int numberi=0;
        boolean ok=false;
        while (!ok){
            try{
                String number=scanner.nextLine();
                numberi=Integer.valueOf(number);
                ok=true;
            }catch (Exception e){
                System.out.println("Nem egész számot adott meg.");
            }
        }

        for (int i = 0; i < numberi; i++) {
            System.out.printf("Kérek egy nevet:");
            String nev=scanner.nextLine();
            System.out.printf("Kérek egy tartalmat:");
            String tartalom=scanner.nextLine();
            bejegyzesek.add(new Bejegyzes(nev,tartalom));
        }
    }

    public void Beolvas(String name) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
            String sor=bufferedReader.readLine();
            while (sor != null && !sor.isEmpty()){
                String[] adatok = sor.split(";");
                bejegyzesek.add(new Bejegyzes(adatok[0],adatok[1]));
                sor = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Likeok(){
        for (int i = 0; i < 20; i++) {
            var x=bejegyzesek.get(r.nextInt(bejegyzesek.size()));
            for (int j = 0; j < bejegyzesek.size(); j++) {
                x.like();
            }
        }
    }

    public void Tartalommodositas(){
        System.out.printf("Kérek egy szöveget:");
        bejegyzesek.get(1).setTartalom(scanner.nextLine());

    }

    public void Kiir(){
        for (Bejegyzes f:bejegyzesek){
            System.out.println(f);
            System.out.println();
        }
    }

    public void LegtobbLike(){
        Bejegyzes like=bejegyzesek.get(0);

        for (Bejegyzes b:bejegyzesek){
            if(b.getLikeok()>like.getLikeok()){
                like=b;
            }
        }
        System.out.println(like.getLikeok());
        if(like.getLikeok()>35){
            System.out.println("Van olyan bejegyzés aminek több mint 35 likeja van.");
        }else{
            System.out.println("Nincs olyan bejegyzés aminek több mint 35 likeja van.");
        }
    }

    public void Kevesebb15like(){
        int szam=0;
        for (Bejegyzes b:bejegyzesek){
            if(b.getLikeok()<15){
                szam++;
            }
        }
        System.out.println(szam);
    }

    public void Likecsokkenosorrend(){
        bejegyzesek.sort((Bejegyzes z1, Bejegyzes z2) -> {
            if (z1.getLikeok() < z2.getLikeok())
                return 1;
            if (z1.getLikeok() == z2.getLikeok())
                return 0;
            return -1;
        });
    }

    public void Kiirfajlba(String name){
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(name));

            for(Bejegyzes b:bejegyzesek){
                w.write(b.toString());
                w.write("\n");
            }
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
