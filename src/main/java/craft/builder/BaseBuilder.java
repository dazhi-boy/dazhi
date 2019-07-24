package craft.builder;

import craft.session.Configuration;

public abstract class BaseBuilder {
    protected final Configuration configuration;
    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }
}
