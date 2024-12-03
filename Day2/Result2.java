import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Result2 {

    static Boolean saveCheck(ArrayList<Integer> report) {

        int damper = 0;

        for (int i = 1; i < report.size(); i ++) {

            int previousLevel = report.get(i - 1);
            int currentLevel = report.get(i);
            int diff = 0;
            boolean increasing = false;

            if (report.get(0) < report.get(4)) {
                increasing = true;
                diff = currentLevel - previousLevel;
            } else {
                diff = previousLevel - currentLevel;
            }

            if (diff >= 4 || diff == 0) {
                damper ++;
                if (i <= report.size() - 1) {
                    if (increasing) {
                        diff = report.get(i + 1) - previousLevel;
                    } else {
                        diff = previousLevel - report.get(i + 1);
                    }
    
                    if (diff >= 4 || diff == 0) {
                        damper ++;
                        return false;
                    }
                }
            }

        }
        if (damper >= 2) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            for (String line : br.lines().toList()) {

                System.out.println(line);

                ArrayList<Integer> report = new ArrayList<Integer>();
                String[] test = line.split(" ");
                for (String level : test) {
                    report.add(Integer.parseInt(level));
                }

                if (saveCheck(report)) {
                    val ++;
                }
                System.out.println(val);
            }
            
            System.out.println("Final result: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
