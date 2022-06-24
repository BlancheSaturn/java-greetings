package com.example.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
@CrossOrigin(origins  =  "http://localhost:3000")
@RestController
public class GreetingController {
    @Autowired GreetingRepository repository;

    ArrayList<Greeting> greetings = new ArrayList<>();

    @GetMapping("/greeting/{id}")
    public ResponseEntity<Greeting> getGreetingID(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByid(parseInt(id)));
    }



//    @GetMapping("/greeting/{id}")
//    public Greeting getGreetingById(@PathVariable String id) {
//        List<Greeting> greetings = getGreetings();
//        return greetings.stream()
//                .filter(greeting -> greeting.getId() == parseInt(id))
//                .findFirst()
//                .orElse(null);
//    }

    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> getGreetings() {
        // make a call to a databse and get all of the greetings
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

//    @GetMapping("/greeting/random")
//        public Greeting getRandomGreeting() {
//        List<Greeting> greetings = repository.findAll();
//        Random rand = new Random();
//        return (greetings.get(rand.nextInt(greetings.size())));
//}

    @GetMapping("/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        List<Greeting> greetings = repository.findAll();
        int randomIndex = (int) Math.floor(greetings.size() * Math.random());
        return ResponseEntity.status(HttpStatus.OK).body(greetings.get(randomIndex));
    }


    @PostMapping("/greeting")
        public ResponseEntity<String> createGreeting(@RequestBody Greeting greeting) {
        repository.save(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).body("New Greeting Added" + greeting.getGreeting());

    }

    @DeleteMapping("/greeting/{id}")
    @Transactional
    public ResponseEntity<String>  deleteGreeting(@PathVariable String id) {
        repository.deleteByid(parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Greeting with Id "
        + id + " has been deleted");
//
            }
        }
