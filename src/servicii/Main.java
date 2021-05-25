package servicii;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException, IOException {
        Servicii myService = new Servicii();
        myService.executareServicii();
    }
}
