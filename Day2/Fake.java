import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fake {

    public static Boolean saveCheck(List<String> numStr) {
        int currentNum = -1;
        int inc = 0;
        boolean safe = true;
        for (String num : numStr) {
            int number = Integer.parseInt(num);
            if (currentNum == -1) {
                currentNum = number;
                continue;
            }
            if (currentNum > number) {
                if (inc > 0) {
                    safe = false;
                    break;
                } else if (inc == 0) {
                    inc = -1;
                }
                if (Math.abs(currentNum - number) > 3) {
                    safe = false;
                    break;
                }
                currentNum = number;
            } else if (currentNum < number) {
                if (inc < 0) {
                    safe = false;
                    break;
                } else if (inc == 0) {
                   inc = 1; 
                }
                if (Math.abs(currentNum - number) > 3) {
                    safe = false;
                    break;
                }
                currentNum = number;
            } else {
                safe = false;
                break;
            }
        }
        return safe;
    }
    
    public static void main (String[] args) throws IOException {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            for (String line : br.lines().toList()) {
                String[] numStr = line.split(" ");

                List<String> numList = new ArrayList<>();
                numList.addAll(Arrays.stream(numStr).toList());
                boolean safe = saveCheck(numList);
                if (!safe) {
                    for (int i = 0; i < numStr.length; i++) {
                        numList = new ArrayList<>();
                        numList.addAll(Arrays.stream(numStr).toList());
                        numList.remove(i);
                        safe = saveCheck(numList);
                        if (safe) break;
                    }
                    if (!safe) System.out.println(line);
                }
                val += safe ? 1 : 0;
            }
            
            System.out.println("Final result: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
