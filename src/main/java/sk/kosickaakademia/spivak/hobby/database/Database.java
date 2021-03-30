package sk.kosickaakademia.spivak.hobby.database;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import sk.kosickaakademia.spivak.hobby.entity.User;
import sk.kosickaakademia.spivak.hobby.log.Log;


/**
 * Connecting to the MongoDB
 */
public class Database {
    Log log = new Log();

    // this is the client that will provide a connection to the database
    private static final MongoClient mongoClient = new MongoClient();

    private DB db;
    private DBCollection table;

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




}
