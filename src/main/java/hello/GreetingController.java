package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Configure JEDIS
    Jedis jedis = new Jedis("localhost", Application.port);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/autocomplete")
    public Greeting getAutocomplete(@RequestParam(required=false) String word) {
        System.out.println("Getting autocomplete");
        jedis.lpush("test#testmore", word);
        return new Greeting(1, "test");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public void search(@RequestParam(required=false) String word) {
        System.out.println("Set in jedis: " + word);
        for (int i = 0; i < word.length(); i++) {
            int d = 5;
        }
    }

}