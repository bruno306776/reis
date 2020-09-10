package br.com.projeto.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Nova2 {

	public static void main(String[] args) throws ClassNotFoundException {
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://" + "ec2-34-195-115-225.compute-1.amazonaws.com" + ':' + "5432/" + "d73bo20pk28v3j"
						+ "?sslmode=require",
				"uyforgrgvlkqzy", "069148fb232bb41c3e39f4d9840ab5206ea57abcde648c1c4c4765a569af6e0f"

		)) {
			// String sql = " CREATE TABLE conta (\r\n" + " user_id serial PRIMARY KEY,\r\n"
			// + " username VARCHAR ( 50 ) UNIQUE NOT NULL,\r\n" + " password VARCHAR ( 50 )
			// NOT NULL,\r\n"
			// + " email VARCHAR ( 255 ) UNIQUE NOT NULL,\r\n" + " created_on TIMESTAMP NOT
			// NULL,\r\n"
			// + " last_login TIMESTAMP \r\n" + ");";

			// String sql = "DROP TABLE conta";
			
			String sql = "CREATE TABLE DADOS ("+ 
					" username varchar (20)," +
					  "rua varchar (100), "+
					  "bairro varchar (50), "+
					  "cidade varchar (50), "+
					  " estado varchar (50) , "+
					  " cep varchar (10)  ) " ; 
			// sql = "DELETE FROM DADOS";
			
			String sql1 = "CREATE TABLE FUTEBOL ("+ 
					" username varchar (20)," +
					  "rua varchar (100), "+
					  "bairro varchar (50), "+
					  "cidade varchar (50), "+
					  " estado varchar (50) , "+
					  " cep varchar (10)  ) " ; 
			
			
						
						
			Statement stmt = conn.createStatement();
			
			// stmt.executeUpdate("Drop Table DADOS");
			// stmt.executeUpdate("Drop Table FUTEBOL");
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);

			sql="insert into DADOS values ('Marcos Alves de Lima','Rosa Julieta Alves','Santana de Parnaiba','Santos','São Paulo','06266-000')" ;
			stmt.executeUpdate(sql);
			
			sql1="insert into FUTEBOL values ('Santos','ZUADO','Teste Bruno','Santos','Teste Rapido','06266-000')" ;
			stmt.executeUpdate(sql1);
			
			
			PreparedStatement select = conn.prepareStatement("select * from DADOS");
			
			 
			  ResultSet rs = select.executeQuery();
			
			  while (rs.next()) {
				    String username = rs.getString("username");
				    String rua = rs.getString("rua");
				    String bairro = rs.getString("bairro");
				    String cidade = rs.getString("cidade");
				    String estado = rs.getString("estado");
				    String cep = rs.getString("cep");
				    		
				    		
				    System.out.println(username + " _ " + rua + " _ " + bairro + " _ " + cidade + " _ " + estado + " _ " + cep);
				  }

				  stmt.close();
				  conn.close();
			  
			  
						
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
