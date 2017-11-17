import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Cache {
    private ApiResponse lastChecked = null;

    public boolean isInCache(String[] currency) throws IOException {
        String data;
        try(FileReader reader = new FileReader("Cache\\" + currency[0] + currency[1] + ".txt")) {
            BufferedReader br = new BufferedReader(reader);
            data = br.readLine();
            br.close();
        }
        catch(IOException ex){
            return false;
        }
        return checkCached(data);
    }

    public boolean checkCached(String data) {
        if (data == null)
            return false;
        ApiResponse cachedData = new DataParser().getResponseObject(data);
        if (cachedData.getDate().compareTo(LocalDate.now().toString()) < 0)
            return false;
        this.lastChecked = cachedData;
        return true;
    }

    public ApiResponse getFromCache(String[] currency) throws IOException {
        if (this.lastChecked != null || this.isInCache(currency)) {
            ApiResponse copy = this.lastChecked;
            this.lastChecked = null;
            return copy;
        }
        return null;
    }

    public void addToCache(String[] currency, String response) {
        try(FileWriter writer = new FileWriter("Cache\\" + currency[0] + currency[1] + ".txt")) {
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(response);
            bw.close();
        }
        catch(IOException ex){
            return;
        }
    }
}