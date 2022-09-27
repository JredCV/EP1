package pe.isil.moduloseguridadep1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

@SpringBootApplication
public class Moduloseguridadep1Application {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(Moduloseguridadep1Application.class, args);

		//Carga de driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Conxion
		Connection conex= DriverManager
				.getConnection("jdbc:mysql://localhost:3306/modulosegep1", "root", "root");


		tstStatement(conex);
		tstPreparedStatement(conex);
		tstCallableStatement(conex);
		conex.close();
	}

	public static void tstStatement(Connection conex) throws Exception{
		//Statement
		Statement statement= conex.createStatement();

		//Exec
		int afectedRows = statement.executeUpdate("UPDATE CELULAR SET MODELO ='A25' WHERE ID=2");
		System.out.println("Filas afectadas: " + afectedRows);

		ResultSet resultSet = statement.executeQuery("SELECT * FROM CELULAR");
		while (resultSet.next()){
			System.out.println(resultSet.getString("modelo"));
		}

		System.out.println("Filas afectadas: " + afectedRows);
	}

	public static void tstPreparedStatement(Connection conex) throws Exception {
		PreparedStatement preparedStatement = conex.prepareStatement("INSERT CELULAR VALUES (NULL,?,?,?,?) ");

		preparedStatement.setString(1, "Huawei");
		preparedStatement.setString(2, "P50 PRO");
		preparedStatement.setString(3, "Android");
		preparedStatement.setInt(4, 25);

		int addRows = preparedStatement.executeUpdate();

		System.out.println("Nuevo celular: " + addRows);
	}

	public static void tstCallableStatement(Connection conex) throws Exception{
		CallableStatement cs = conex.prepareCall("{call getAllCelulares()} ");

		ResultSet res= cs.executeQuery();

		while (res.next()) {
			System.out.println( res.getString("marca")+ " " +
								res.getString("modelo")+ " " +
								res.getInt("stock")
			);
		}
	}
}
