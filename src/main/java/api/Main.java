package api;

import java.io.InputStream;

import api.app.Application;
import api.app.Config;

public class Main {
    public static void main(String[] args) {
        try {
            var cfg = new Config();
            var server = new Application(cfg);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}