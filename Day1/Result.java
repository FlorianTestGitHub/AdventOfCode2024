import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Result {
    
    public static void main (String[] args) {

        ArrayList<String> leftRow = new ArrayList<String>();
        ArrayList<String> rightRow = new ArrayList<String>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int val = 0;
            for (String line : br.lines().toList()) {

                String[] test = line.split(" ");
                leftRow.add(test[0]);

                String[] test2 = line.split(" ");
                rightRow.add(test2[3]);

                Collections.sort(leftRow);
                Collections.sort(rightRow);
            }
            for (int i = 0; i < leftRow.size(); i++) {

                int counter = 0;
                int left = Integer.parseInt(leftRow.get(i));
                
                for (int x = 0; x < rightRow.size(); x ++) {

                    int right = Integer.parseInt(rightRow.get(x));

                    if (left == right) {
                        counter ++;
                    }
                }
                if (counter > 0) {
                    val += left * counter;
                }
            }
            System.out.println(val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
