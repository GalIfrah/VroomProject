package Services;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoService {

	MongoClient mongoclient;
	MongoDatabase database;

	public void connectToMongo() {
		mongoclient = new MongoClient("localhist", 27017);

		System.out.println("connected to mongo deamon");
	}

	public void getDB(MongoClient mongoclient, String dbName) {
		database = mongoclient.getDatabase(dbName);
	}

	public String getDbName() {
		String dbName = database.getName();
		return dbName;
	}

	public void addCollection(String collName) {
		database.createCollection(collName);

	}

	public void closeMongoSession() {
		mongoclient.close();
		System.out.println("session ended 2");
	}

}
