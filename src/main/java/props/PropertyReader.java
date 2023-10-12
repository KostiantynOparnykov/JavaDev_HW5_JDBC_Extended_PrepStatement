package props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getConnectionUrlForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to find application.properties");
                return null;
            }
            properties.load(input);

            return "jdbc:postgresql://" +
                    properties.getProperty("postgres.db.host") +
                    ":" +
                    properties.getProperty("postgres.db.port") +
                    "/" +
                    properties.getProperty("postgres.db.database") +
                    "?currentSchema=public";
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to find application.properties");
                return null;
            }
            properties.load(input);

            return properties.getProperty("postgres.db.username");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getPasswordForPostgres(){
        try(InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties properties = new Properties();

            if(input == null){
                System.out.println("Unable to load application.properties");
                return null;
            }
            properties.load(input);
            return properties.getProperty("postgres.db.password");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
