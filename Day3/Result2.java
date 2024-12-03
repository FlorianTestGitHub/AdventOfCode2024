import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Result2 {

    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            List<String> matches = new ArrayList<>();
            for (String line : br.lines().toList()) {

                String regexMul = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";
                Pattern pattern = Pattern.compile(regexMul);
                Matcher matcher = pattern.matcher(line);


                while (matcher.find()) {
                    matches.add(matcher.group());
                }
                System.out.println(matches);
            }
            
            boolean skip = false;
            for (String item : matches) {
                if (item.equals("don't()")) {
                    skip = true;
                } else if (item.equals("do()")) {
                    skip = false;
                } else if (item.startsWith("mul") && !skip) {
                    String[] numbers = item.substring(4, item.length() -1).split(",");
                    int num1 = Integer.parseInt(numbers[0].trim());
                    int num2 = Integer.parseInt(numbers[1].trim());
                    val += num1 * num2;
                }
            }
            
            System.out.println("Final result: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
