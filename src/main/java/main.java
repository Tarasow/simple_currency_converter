import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        getExchangeRates();
    }

    private static void getExchangeRates() throws Exception {
        boolean wantToCheck = true;
        Scanner in = new Scanner(System.in);
        do {
            try {
                getRate();
            }
            catch (Exception e) {
                return;
            }
            System.out.println("\nDo you want to know other exchange rates [y/n]?");
            String userResponse = in.nextLine().toLowerCase();
            if (!userResponse.equals("y"))
                wantToCheck = false;
        } while (wantToCheck);
    }

    private static void getRate() throws Exception {
        String[] currency = new UserIO().getUserData();
        String answer = new DataParser().getAnswer(currency);
        System.out.println(answer);
    }
}