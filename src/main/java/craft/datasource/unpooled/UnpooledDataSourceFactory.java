package craft.datasource.unpooled;

import craft.datasource.DataSourceFactory;
import craft.reflection.MetaObject;
import craft.reflection.SystemMetaObject;

import javax.sql.DataSource;
import java.util.Properties;

public class UnpooledDataSourceFactory implements DataSourceFactory {

    private static final String DRIVER_PROPERTY_PREFIX = "driver.";
    private static final int DRIVER_PROPERTY_PREFIX_LENGTH = DRIVER_PROPERTY_PREFIX.length();

    protected DataSource dataSource;

    public UnpooledDataSourceFactory(){
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Properties properties) {
        Properties driverProperties = new Properties();
        MetaObject metaDataSource = SystemMetaObject.forObject(dataSource);
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
