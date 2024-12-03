import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Result1 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            for (String line : br.lines().toList()) {

                Boolean save = true;
                int lastLevel = 0;
                Boolean sameDirection = false;
                int incCounter = 0;
                int decCounter = 0;

                
                String[] test = line.split(" ");
                
                for (String level : test) {

                    int currentLevel = Integer.parseInt(level);

                    if (lastLevel != 0) {
                        if (lastLevel >= currentLevel) {
                            decCounter ++;
                            int diff = lastLevel - currentLevel;
                            if (diff >= 4 || diff == 0) {
                                save = false;
                            }
                        } else if (lastLevel < currentLevel) {
                            incCounter ++;
                            int diff = currentLevel - lastLevel;
                            if (diff >= 4 || diff == 0) {
                                save = false;
                            }
                        }
                    }
                    lastLevel = currentLevel;
                }
                if (incCounter == 0 || decCounter == 0) {
                    sameDirection = true;
                }
                if (save && sameDirection) {
                    val ++;
                }
            }
            
            System.out.println("Final result: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
