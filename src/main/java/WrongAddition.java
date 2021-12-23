import java.util.Scanner;

// Wrong Addition
public class WrongAddition {

    private static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String a = tokens[0];
            String s = tokens[1];
            int aInd = a.length() - 1;
            int sInd = s.length() - 1;
            StringBuilder sb = new StringBuilder();
            boolean isValid = true;
            while (aInd >= 0 && sInd >= 0) {
                int c = Integer.parseInt(a.charAt(aInd) + "");
                int d = Integer.parseInt(s.charAt(sInd) + "");
                if (d >= c) {
                    sb.append(d - c);
                    sInd--;
                } else {
                    if (sInd - 1 < 0) {
                        isValid = false;
                        break;
                    } else {
                        d = Integer.parseInt(s.charAt(sInd - 1) + "" + s.charAt(sInd));
                        if (d - c > 9 || d - c < 0) {
                            isValid = false;
                            break;
                        } else {
                            sb.append(d - c);
                        }
                    }
                    sInd -= 2;
                }
                aInd--;
            }
            while (aInd < 0 && sInd >= 0) {
                sb.append(s.charAt(sInd) + "");
                sInd--;
            }
            if (aInd >= 0 && sInd < 0) {
                System.out.println("-1");
            } else if (isValid) {
                sb = sb.reverse();
                int leadingZeros = 0;
                while (leadingZeros < sb.length() && sb.charAt(leadingZeros) == '0') {
                    leadingZeros++;
                }
                System.out.println(sb.substring(leadingZeros));
            } else {
                System.out.println("-1");
            }
        }
    }
}
