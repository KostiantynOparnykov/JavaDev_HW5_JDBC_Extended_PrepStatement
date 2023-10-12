package sqlReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SqlReader {
    public String read(String sqlFilePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
            StringBuffer sb = new StringBuffer();
            reader.lines().forEach(str -> {
                sb.append(str);
                sb.append("\n");
            });
            return sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
