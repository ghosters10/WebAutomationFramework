package externalconnectors;

public final class DBConnector {
	
	// Singleton Pattern
	
	private static DBConnector dbConnector;
	
	// no one can create an object of this class
	private DBConnector() {
		
	}
	
	public static DBConnector getInstance() {
		if(dbConnector==null) {			
			createDBConnection();
		}
		return dbConnector;
	}
	
	private static void createDBConnection() {
		// create an active DB connection
		dbConnector = new DBConnector();
	}
	
	public void searchQuery(String sqlQuery) {		
		// fire a query and get the result set		
	}
	
	public static void closeConnection() {
		// if(dbConnector !=null)
		// dbConnector.close();
	}
	
	public static void main(String[] args) {
		// to get same hashcode
		System.out.println(DBConnector.getInstance().hashCode());
		System.out.println(DBConnector.getInstance().hashCode());
		System.out.println(DBConnector.getInstance().hashCode());
	}

}
