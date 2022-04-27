importjava.sql.ResultSet;
importjava.sql.SQLException;
importjava.sql.Statement;
importjava.util.Scanner;

public class Code1 {

	public static void main(String[] args) throwsClassNotFoundException, SQLException {

	Connectionconn;
	Stringname;

	int age, salary, empId, n;

	Scanner sc = new Scanner(System.in);

	Class.forName("com.mysql.cj.jdbc.Driver");

	conn = DriverManager.getConnection("jdbc:mysql://localhost:3360/students", "root", "");

	System.out.println("Connected with database successfully");

	System.out.println(conn);


	DatabaseMeta Datadbm = conn.getMetaData();


	ResultSettables = dbm.getTables(null, null, "employeesData", null);

	if (tables.next())

	{

		System.out.println("Table aready exist");
	}
	else
	{

		Statement st1 = conn.createStatement();

		String str = "CREATE TABLE employeesData"+

		"(EmpId int, " +

		"Name varchar(255)," +

		"Age int,"+

		"Salary int )";

		st1.executeUpdate(str);

		System.out.println("Employee table is created");
	
}

		System.out.print("Enter the number of record do you want to add in database: ");

		n = sc.nextInt();

	while(n != 0)

	{

		System.out.print("Enter the employee id: ");
		empId = sc.nextInt();

		System.out.print("Enter the name: ");	
		name = sc.next();

		System.out.print("Enter the age: ");		
		age = sc.nextInt();

		System.out.print("Enter the salary: ");	
		salary = sc.nextInt();

		PreparedStatementst2 = conn.prepareStatement("insert into employeesData(EmpId, Name, Age, Salary) values(?, ?, ?, ?)");

		st2.setInt(1, empId);
	
		st2.setString(2, name);

		st2.setInt(3, age);

		st2.setInt(4, salary);

		st2.executeUpdate();

		System.out.println("Successfully inserted");

		System.out.println();

		n--;

	}

	sc.close();
	conn.close();

}

}
