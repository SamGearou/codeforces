import java.util.ArrayList;
import java.util.List;

// Cantor Expansion
public class CantorExpansion {

    public static void main(String[] args) {
        for (int term : new CantorExpansion().decimalToCantor(3413)) {
            System.out.println(term);
        }
    }

    /**
     * @return the terms of the cantor expansion (a_i, a_(i-1), ...., a_1)
     */
    public List<Integer> decimalToCantor(int num) {
        List<Integer> terms = new ArrayList<>();
        int n = 0;
        while (num != 0) {
            terms.add(num % (n + 2));
            num = (num - terms.get(terms.size() - 1)) / (n + 2);
            n++;
        }
        return terms;
    }
}
