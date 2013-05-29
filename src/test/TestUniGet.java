package test;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.BD;

public class TestUniGet {


	public static void main(String[] args) {
		String sql_query = "SELECT id,idtenda,idjoc FROM unitats;";
		String sql_count = "SELECT count(*) from unitats;";
		ArrayList<String> camps = new ArrayList<String>();
		Object[][] dades;
		Statement sentencia;
		ResultSet resul;
		ResultSet noms;
		BD bd = new BD();
		
		try {
			bd.connecta("ruben", "ruben");
			// Noms columnes
			DatabaseMetaData dbmd = bd.getConnection().getMetaData();
			noms = dbmd.getColumns(null, null, "unitats", null);
			while (noms.next()) {
				System.out.println(noms.getString("COLUMN_NAME").toUpperCase());
				camps.add(noms.getString("COLUMN_NAME").toUpperCase());
			}
			camps.add("SELECCIONAR");
			System.out.println("CAMPS-->"+camps.size());

			// Dades
			sentencia = bd.getConnection().createStatement();
			resul = sentencia.executeQuery(sql_count);
			resul.next();
			dades = new Object[resul.getInt(1)][camps.size()];
			resul = sentencia.executeQuery(sql_query);
			int x = 0;
			int y = 0;
			while (resul.next()) {
				for(y=0;y<camps.size()-1;y++){
					dades[x][y] = resul.getString(y+1);
				}
				dades[x][y] = false;
				x++;
			}
			for(x=0;x<dades.length;x++){
				for(y=0;y<dades[x].length;y++){
					System.out.print(dades[x][y]+"--");
				}
				System.out.println();
			}
			//Taula table = new Taula(dades, camps.toArray(new String[camps.size()]), 500, 500);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
