package craft.datasource.unpooled;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnpooledDataSourceTest {

    @Test
    public void shouldNotRegisterTheSameDriverMultipleTimes() throws Exception{
        UnpooledDataSource dataSource = null;
        dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=UTF8","root","root");
        dataSource.getConnection().close();
        int before = countRegisteredDrivers();
        dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=UTF8","root","root");
        dataSource.getConnection().close();
        assertEquals(before, countRegisteredDrivers());
    }
//    C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\5.1.45\mysql-connector-java-5.1.45.jar
    @Test
    public void shouldRegisterDynamicallyLoadedDriver() throws Exception {
        int before = countRegisteredDrivers();
        ClassLoader driverClassLoader = null;
        UnpooledDataSource dataSource = null;
        driverClassLoader = new URLClassLoader(new URL[] { new URL("jar:file:/PATH_TO/mysql-connector-java-5.1.25.jar!/") });
//        dataSource = new UnpooledDataSource(driverClassLoader, "com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/test", "root", "");
        dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=UTF8","root","root");
        dataSource.getConnection().close();
        assertEquals(before + 1, countRegisteredDrivers());
        driverClassLoader = new URLClassLoader(new URL[] { new URL("jar:file:/PATH_TO/mysql-connector-java-5.1.25.jar!/") });
//        dataSource = new UnpooledDataSource(driverClassLoader, "com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/test", "root", "");
        dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=UTF8","root","root");
        dataSource.getConnection().close();
        assertEquals(before + 1, countRegisteredDrivers());
    }

    private int countRegisteredDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        int count = 0;
        while (drivers.hasMoreElements()){
            drivers.nextElement();
            count++;
        }
        return count;
    }
}
