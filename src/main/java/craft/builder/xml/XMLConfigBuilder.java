package craft.builder.xml;

import craft.builder.BaseBuilder;
import craft.executor.ErrorContext;
import craft.parsing.XPathParser;
import craft.session.Configuration;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class XMLConfigBuilder extends BaseBuilder {

    private boolean parsed;
    private final XPathParser parser;
    private String environment;

    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        this(new XPathParser(inputStream, true, props, new XMLMapperEntityResolver()), environment, props);
    }

    private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
        super(new Configuration());
        ErrorContext.instance().resource("SQL Mapper Configuration");
        this.configuration.setVariables(props);
        this.parsed = false;
        this.environment = environment;
        this.parser = parser;
    }

    public Configuration parse() {
        System.out.println("hahahahahahaahaha");
        return null;
    }
}
