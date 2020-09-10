package br.com.projeto.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.projeto.projeto.model.Projeto;
import net.bytebuddy.asm.Advice.Return;

public class Nova1 {

	public static void main(String[] args) throws ClassNotFoundException {
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://" + "ec2-34-195-115-225.compute-1.amazonaws.com" + ':' + "5432/" + "d73bo20pk28v3j"
						+ "?sslmode=require",
				"uyforgrgvlkqzy", "069148fb232bb41c3e39f4d9840ab5206ea57abcde648c1c4c4765a569af6e0f"

		)) {
	
			
			String sql = "CREATE TABLE ACESSO ("+    
					" username varchar (50)," +
					  "login varchar (50), "+
					  "senha varchar (50), "+
					  "email varchar (50) )";
			  				
			
					
						
			Statement stmt = conn.createStatement();
			
					
			
			stmt.executeUpdate(sql);
		

			sql="insert into ACESSO values ('Bruno Reis','breis','170192','bsantos_reis@hotmail.com');" ;
			sql+="insert into ACESSO values ('Lucas Almeida','lalmeida','180793','lamieda_santos@hotmail.com');" ;
			sql+="insert into ACESSO values ('Rodolfo Matos','rmatos','200492','rmatos_alves@hotmail.com');" ;
			sql+="insert into ACESSO values ('Larissa Santos','lsantos','170194','lsantos_alves@hotmail.com');" ;
			sql+="insert into ACESSO values ('Marcos Alemeida','malmeida','201095','malmeida_mattos@hotmail.com');" ;
			sql+="insert into ACESSO values ('Jessica Miranda','jmiranda','170499','lmiranda_silva@hotmail.com');" ;
			sql+="insert into ACESSO values ('Aline Riscado','ariscado','201091','ariscado_silva@hotmail.com');" ;
			sql+="insert into ACESSO values ('Amado Batista','abatista','170394','abatista_almeida@hotmail.com');" ;
			sql+="insert into ACESSO values ('Jenifer Rosa','jrosa','170193','jrosa_miranda@hotmail.com');" ;
			sql+="insert into ACESSO values ('Gustavo Lima','glima','170493','glima_tadeu@hotmail.com');" ;
			sql+="insert into ACESSO values ('Rose Rios','rrios','200699','rrios_alves@hotmail.com');" ;
			sql+="insert into ACESSO values ('Katarina Jessica','kjessica','150593','kjessica_miranda@hotmail.com');" ;
			sql+="insert into ACESSO values ('Joao Miranda','jmiranda','140594','jmiranda_santos@hotmail.com');" ;
			sql+="insert into ACESSO values ('Anuar Santos','asantos','170393','asantos_silva@hotmail.com');" ;
			sql+="insert into ACESSO values ('Marcela Danadinha','mdanadinha','230699','mdanadinha_almeida@hotmail.com');" ;
			
			
			
			
			stmt.executeUpdate(sql);
			
	
			
					
				    		
				   		
				 
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

	
	public static Projeto buscadados(String Login ) {
		Projeto p=new Projeto ();
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://" + "ec2-34-195-115-225.compute-1.amazonaws.com" + ':' + "5432/" + "d73bo20pk28v3j"
						+ "?sslmode=require",
				"uyforgrgvlkqzy", "069148fb232bb41c3e39f4d9840ab5206ea57abcde648c1c4c4765a569af6e0f"

		)) {
			PreparedStatement select = conn.prepareStatement("select * from acesso where login ='"+Login+"'");
			
			 
			  ResultSet rs = select.executeQuery();
			
			  while (rs.next()) {
				    String username = rs.getString("username");
				    String login = rs.getString("login");
				    String senha = rs.getString("senha");
				    String email = rs.getString("email");
				 
				    		
				   p.setEmail(email);	
				   p.setLogin(login);
				   p.setSenha(senha);
				   p.setUsername(username);
				   
				  }			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
		
		
		
	}
	
	
	
	
	
}
