import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class UserIO {
    private Scanner in = new Scanner(System.in);
    private boolean letsFinish = false;

    public String[] getUserData() throws Exception {
        String fromCurrency = getFromCurrency();
        if (this.letsFinish)
            throw new Exception("exit");
        String toCurrency = getToCurrency();
        if (this.letsFinish)
            throw new Exception("exit");
        System.out.println();
        String[] currencyArray = { fromCurrency, toCurrency };
        return currencyArray;
    }

    private String getFromCurrency() {
        System.out.println("Enter from currency: ");
        return getCurrency(true);
    }

    private String getToCurrency() {
        System.out.println("Enter to currency: ");
        return getCurrency(false);
    }

    private String getCurrency(boolean isFrom) {
        String currency = in.nextLine().toUpperCase();
        try {
            checkCurrency(currency);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Do you want to try again [y/n]?");
            String userResponse = in.nextLine().toLowerCase();
            if (!userResponse.equals("y")) {
                this.letsFinish = true;
                return "";
            }
            currency = isFrom ? getFromCurrency() : getToCurrency();
        }
        return currency;
    }

    private void checkCurrency(String currency) throws Exception {
        if (allCurrency.get(currency) == null) {
            throw new Exception(currency + " - there is no such currency");
        }
    }

    // maybe it is bad style, but hash with possible currency instead array
    // is better because can check currency for O(1) instead O(n) in array :D
    private static final Map<String, String> allCurrency = new HashMap() {
        {
            put("AUD", "");
            put("BGN", "");
            put("BLR", "");
            put("CAD", "");
            put("CHF", "");
            put("CNY", "");
            put("CZK", "");
            put("DKK", "");
            put("GBP", "");
            put("HKD", "");
            put("HRK", "");
            put("HUF", "");
            put("IDR", "");
            put("ILS", "");
            put("INR", "");
            put("JPY", "");
            put("KRW", "");
            put("MXN", "");
            put("MYR", "");
            put("NOK", "");
            put("NZD", "");
            put("PHP", "");
            put("PLN", "");
            put("RON", "");
            put("RUB", "");
            put("SEK", "");
            put("SGD", "");
            put("THB", "");
            put("TRY", "");
            put("USD", "");
            put("ZAR", "");
            put("EUR", "");
        }
    };
}