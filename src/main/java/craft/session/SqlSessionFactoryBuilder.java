package craft.session;

import craft.builder.xml.XMLConfigBuilder;
import craft.exceptions.ExceptionFactory;
import craft.executor.ErrorContext;
import craft.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) {
        try {
            XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null, null);
            return build(parser.parse());
        }catch (Exception e){
            throw ExceptionFactory.wrapException("Error building SqlSession.", e);
        }finally {
            ErrorContext.instance().reset();
            try {
                inputStream.close();
            }catch (IOException e){

            }
        }
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
