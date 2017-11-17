public class ApiResponse {
    private String base;
    private String date;
    private RateObject rates;

    public String getBase() {
        return this.base;
    }

    public String getDate() {
        return this.date;
    }

    public String getTo() {
        return this.rates.getName();
    }

    public double getRate() {
        return this.rates.getRate();
    }
}