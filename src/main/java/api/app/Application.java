package api.app;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.LoggerFactory;

import api.dao.Dao;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Application {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Application.class);
    private static final Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    static {
        rootLogger.setLevel(Level.INFO);
    }

    Config cfg;

    public Application(final Config _cfg) {
        cfg = _cfg;
    }

    private void addShutdownHook(final Runnable hook) {
        Runtime.getRuntime().addShutdownHook(new Thread(hook));
    }

    public void start() {
        var dao = new Dao(cfg.db_connection, cfg.db_username, cfg.db_password);
        try {
            dao.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        addShutdownHook(() -> {
            try {
                dao.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        });

        var resourceConfig = new ResourceConfig();
        resourceConfig.packages("api.controller");
        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(dao).to(Dao.class);
            }
        });

        var baseUri = UriBuilder.fromUri(cfg.server_address).port(cfg.server_port).build();
        var server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);
        try {
            server.start();
            logger.info("status: " + server.isRunning());
            logger.info("AAAAAAAAAAAAAA {}:{}", cfg.server_address, cfg.server_port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}