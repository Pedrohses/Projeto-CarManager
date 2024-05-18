package api.app;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public final class Config {
    public final String server_address = "http://localhost";
    public final int server_port = 7780;

    public final String db_connection = "jdbc:postgresql://localhost:5432/postgres";
    public final String db_username = "postgres";
    public final String db_password = "senha";
}