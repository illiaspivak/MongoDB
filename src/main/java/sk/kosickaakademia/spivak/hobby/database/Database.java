package sk.kosickaakademia.spivak.hobby.database;


import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.mongodb.MongoClient;
import org.json.simple.parser.ParseException;
import sk.kosickaakademia.spivak.hobby.entity.User;
import sk.kosickaakademia.spivak.hobby.log.Log;


import java.util.ArrayList;
import java.util.List;


/**
 * Connecting to the MongoDB
 */
public class Database {
    Log log = new Log();

    // this is the client that will provide a connection to the database
    private static final MongoClient mongoClient = new MongoClient();

    private DB db;
    private DBCollection table;

    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public Database(){
        log.info("Connecting to the database");
        //Create database and collection
        db = mongoClient.getDB("hobby");
        table = db.getCollection("users");
    }

    /**
     * Add the user to the database
     * @param user
     */
    public boolean insertNewUser(User user){
        if (user==null){
            log.error("Not enough data");
            return false;
        }
        BasicDBObject document = new BasicDBObject();

        document.put("login", user.getLogin());
        document.put("hobby",user.getHobby());

        table.insert(document);
        log.print("User added to the database");
        return true;
    }

    public User getByLogin(String login){
        BasicDBObject query = new BasicDBObject();

        query.put("login", login);

        log.info("Performing a search");
        DBObject result = table.findOne(query);


        User user = new User();
        user.setLogin(String.valueOf(result.get("login")));
        user.setHobby(String.valueOf(result.get("hobby")));

        return user;
    }

    /**
     * Creating a list of users
     * @return List<Users>
     */
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        database = mongoClient.getDatabase("hobby");
        collection = database.getCollection("users");
        MongoCollection<Document> table = collection;
        for (Document doc : table.find()){
            try {
                JSONObject object = (JSONObject) new JSONParser().parse(doc.toJson());
                list.add(new User((String) object.get("login"), (String) object.get("hobby")));
            } catch (ParseException e) {
                log.error(e.toString());
            }
        }
        log.print("List of users created");
        return list;
    }





}
