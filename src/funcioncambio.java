package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class funcioncambio {
	public funcioncambio(){}
	public double valor(double valor,String monedaInternacional,String monedaLocal){
		double res=0;
		if(RangoNumero(valor) == false) res=0; // retorna 0.0 si supera rango
		else{ 
		if(esDistinto(monedaInternacional, monedaLocal)) res=valor; // retorna el mismo valor si es el mismo tipo de moneda
		else{
		URL url;
			try {
				url = new URL("http://es.exchange-rates.org/converter/"+monedaInternacional+"/"+monedaLocal+"/"+valor+"/Y");
				URLConnection con = url.openConnection();
			    InputStream s = con.getInputStream();
			    List<String> listas= IOUtils.readLines(s);// convertimos html a un lista de strings
			    String line = listas.get(259); // obtenemos linea exacta
			    String [] cadena = line.split(">"); // dividimos linea 
	            res = redondear(Double.parseDouble(extraer(cadena[1],0))); //redondea a 2 decimales el resultado
	        } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	    }
		}
	       return res;
		}
		private String extraer(String cadena,int pos){
	    	String res="";
	    	if (cadena.charAt(pos) == '<'){
	    		res="";
	    	}else{
	    		if (cadena.charAt(pos) == ',') res = '.'+extraer(cadena,pos+1);
	    		else res=cadena.charAt(pos)+extraer(cadena,pos+1);
	    	}
	    	   return res;
	       }
		public boolean RangoNumero(double numero){
			return (numero > 0 && numero < 1000000);
		}
		public boolean esDistinto(String tipo,String tipo2){
			return(tipo.equals(tipo2));
		}
		public double redondear(double valor)
		{
			int cifras=(int) Math.pow(10,2);
			return (Math.rint(valor*cifras)/cifras);
			
		}
}
