package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
import db.DatabaseConnection;

public class EmployeeDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DatabaseConnection.driverClass);
			con = DriverManager.getConnection(DatabaseConnection.connectionUrl, DatabaseConnection.username,
					DatabaseConnection.password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int saveEmployee(Employee employee) {
		int status = 0;

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("insert into user905(name,password,email,country ) values(?,?,?,?)");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getCountry());
			status = preparedStatement.executeUpdate();

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return status;
	}

	public static List<Employee> getAllRecods() {

		List<Employee> employeelist = new ArrayList<Employee>();

		try {
			Connection con=EmployeeDao.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement("select * from user905");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee=new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setName(resultSet.getString(3));
				employee.setName(resultSet.getString(4));
				employee.setName(resultSet.getString(5));
employeelist.add(employee);
System.out.println(employeelist);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return employeelist;

	}

}
