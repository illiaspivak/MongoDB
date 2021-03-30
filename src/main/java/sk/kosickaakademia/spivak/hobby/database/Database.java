package sk.kosickaakademia.spivak.hobby.database;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sk.kosickaakademia.spivak.hobby.log.Log;

import java.net.UnknownHostException;

/**
 * Connecting to the MongoDB
 */
public class Database {
    Log log = new Log();

    // this is the client that will provide a connection to the database
    private static final MongoClient mongoClient = new MongoClient();

    //create database
    private static MongoDatabase database;

    //create collection
    private static MongoCollection<Document> collection;




}
