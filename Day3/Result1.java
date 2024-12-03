import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Result1 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            for (String line : br.lines().toList()) {

                String regexMul = "mul\\((\\d+),(\\d+)\\)";
                Pattern pattern = Pattern.compile(regexMul);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));

                    val += num1 * num2;
                }
            }
            
            System.out.println("Final result: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
