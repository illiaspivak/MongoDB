package sk.kosickaakademia.spivak.hobby.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.kosickaakademia.spivak.hobby.database.Database;
import sk.kosickaakademia.spivak.hobby.entity.User;
import sk.kosickaakademia.spivak.hobby.log.Log;

@RestController
public class Controller {
    Log log = new Log();

    /**
     * Method POST: Adding a new user to the database
     * @param data
     * @return status
     */
    @PostMapping("/user/new")
    public ResponseEntity<String> insertNewUser(@RequestBody String data){
        try {
            JSONObject object = (JSONObject) new JSONParser().parse(data);
            String login = ((String)object.get("login"));
            String hobby = ((String)object.get("hobby"));

            log.info("Checking if there are any input data");
            if(login==null || hobby==null){
                log.error("Not enough data");
                JSONObject objectError = new JSONObject();
                objectError.put("error", "Not enough data");
                return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(objectError.toJSONString());
            }

            log.info("Adding a new resident to the database");
            User user = new User(login, hobby);

            new Database().insertNewUser(user);
            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body("New resident has been added to the database");

        } catch (Exception e) {
            JSONObject obj = new JSONObject();
            log.error("Cannot process input data ");
            obj.put("error","Cannot process input data ");
            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(obj.toJSONString());
        }
    }


    /**
     * Method GET: Show all users
     * @return json
     */
    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers(){
        String json = new Database().getAllUsers();
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(json);
    }
}
