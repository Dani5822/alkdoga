import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        feladatok f=new feladatok();
        f.Kezdet();
        f.bejegyzeshozzaadas();
        f.Beolvas("bejegyzesek.csv");
        f.Likeok();
        f.Tartalommodositas();
        f.Kiir();
        f.LegtobbLike();
        f.Kevesebb15like();
        f.Likecsokkenosorrend();
        f.Kiir();
        f.Kiirfajlba("bejegyzesek_rendezett.txt");

    }
}