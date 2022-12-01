import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("inputs/Tag1.txt"));

        int kalorien = 0;
        int meistenKalorien = 0;

        List<Integer> kalorienListe = new ArrayList<>();

        String line;
            while ((line = br.readLine()) != null) {
                String strKal = line.trim();
                if (strKal.isBlank()) {
                    if (meistenKalorien < kalorien) {
                        meistenKalorien = kalorien;
                    }
                    kalorienListe.add(kalorien);
                    kalorien = 0;
                    continue;
                }
                kalorien += Integer.parseInt(strKal);
            }
            kalorienListe.add(kalorien);
            if (meistenKalorien < kalorien) {
                meistenKalorien = kalorien;
            }
            System.out.println(meistenKalorien);
            kalorienListe.sort((a, b) -> b - a);
            System.out.println(kalorienListe.get(0) + kalorienListe.get(1) + kalorienListe.get(2));
    }
}