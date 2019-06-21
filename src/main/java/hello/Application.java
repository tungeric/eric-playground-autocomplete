package hello;

import java.io.IOException;
import java.net.ServerSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

@SpringBootApplication
public class Application {

    private static RedisServer redisServer;
    public static int port;

    public static void main(String[] args) {
        try {
            setUp();
        } catch (Exception e) {
            System.out.println("setup didn't work");
            System.out.println(e.getLocalizedMessage());
        }
        SpringApplication.run(Application.class, args);
    }

    public static void setUp() throws IOException {

        // Take an available port
//        ServerSocket s = new ServerSocket(0);
//        port = s.getLocalPort();
        port = 6379;
        System.out.println("PORT IS: " + port);
//        s.close();

        redisServer = new RedisServer(port);
        redisServer.start();
    }
}