import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    static final int stein = 1;
    static final int papier = 2;
    static final int schere = 3;

    static final int niederlage = 0;
    static final int gleichstand = 3;
    static final int sieg = 6;

    public static void main(String[] args) throws Exception {
        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("A", stein);
        shapes.put("B", papier);
        shapes.put("C", schere);
        shapes.put("X", stein);
        shapes.put("Y", papier);
        shapes.put("Z", schere);


        BufferedReader br = new BufferedReader(new FileReader("inputs/Tag2.txt"));

        int score = 0;

        int predscore = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String[] match = line.trim().split(" ");

            if (match.length != 2) continue;

            if (Objects.equals(shapes.get(match[0]), shapes.get(match[1]))) {
                score += gleichstand;
            } else if (
                    shapes.get(match[0]) == stein &&
                            shapes.get(match[1]) == papier
            ) score += sieg;
            else if (
                    shapes.get(match[0]) == papier &&
                            shapes.get(match[1]) == schere
            ) {
                score += sieg;
            } else if (
                    shapes.get(match[0]) == schere &&
                            shapes.get(match[1]) == stein
            ) {
                score += sieg;
            } else {
                score += niederlage;
            }

            score += shapes.get(match[1]);

            if (match[1].equals("X")) {
                predscore += niederlage;

                if (shapes.get(match[0]) == stein) {
                    predscore += schere;
                }
                if (shapes.get(match[0]) == papier) {
                    predscore += stein;
                }
                if (shapes.get(match[0]) == schere) {
                    predscore += papier;
                }
            }
            if (match[1].equals("Y")) {
                predscore += gleichstand;
                predscore += shapes.get(match[0]);
            }
            if (match[1].equals("Z")) {
                predscore += sieg;

                if (shapes.get(match[0]) == stein) {
                    predscore += papier;
                }
                if (shapes.get(match[0]) == papier) {
                    predscore += schere;
                }
                if (shapes.get(match[0]) == schere) {
                    predscore += stein;
                }
            }
        }

        System.out.println(score);
        System.out.println(predscore);
    }
}
