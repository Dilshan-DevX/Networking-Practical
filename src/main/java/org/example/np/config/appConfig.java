package org.example.np.config;

import org.glassfish.jersey.server.ResourceConfig;

public class appConfig extends ResourceConfig {
    public appConfig() {
        packages("org.example.np.ctrlr");
        packages("org.example.np.middleware");
    }
}
