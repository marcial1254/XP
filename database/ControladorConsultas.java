package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorConsultas
{
	//private PostgresConn conector;

	//los metodos de PostgresConn son estaticos
	public ControladorConsultas()
	{
		//conector = new PostgresConn()
	}

	//ejempplo
	/*
	public ArrayList<String> getNombresPersonas()
	{
		ArrayList<String> nombres = new ArrayList<String>();
		ResultSet resultado = PostgresConn.consultar("SELECT nombre FROM persona");
		while(resultado.next)
		{
			String nombre = resultado.getString(1);
			nombres.add(nombre);
		}
		return nombres;
	}
	*/
}