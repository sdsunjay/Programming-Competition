import java.util.*;
import java.lang.*;
/*Amazon programming context*/

public class Proteins{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line;
        int num1;
        int num2;
        int output = 0;
        ArrayList<Integer> x = new ArrayList<Integer>();

        num1 = scan.nextInt();
        num2 = scan.nextInt();
        line = scan.next();
        for (int i = 0; i < num1 * num2; i++) {
            if (i + 1 < num1 * num2) {
                if ((line.charAt(i) == line.charAt(i + 1)) && (line.charAt(i) == 'H')) {
                    output++;
                }
            }
            if (line.charAt(i) == 'H') {
                x.add(i);
            }
        }
        for (int i = 0; i < x.size(); i++) {
            for (int ii = 0; ii < x.size(); ii++) {
                if ((x.get(i).equals(ii / 2)) && ii != i) {
                    output++;
                }
            }
        }
        System.out.println(output);

    }
}
