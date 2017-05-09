package com.mercadolibre.examen;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.mercadolibre.examen.command.TraceIpCommand;
import com.mercadolibre.examen.command.TraceIpResult;
import com.mercadolibre.examen.rest.services.exceptions.UnavailableCountryDataException;

/**
 * Mercado Libre: Ejercicio de programación.
 *
 * @author Mariano Gomez
 *
 */
public class Main {
	
    /**
     * Metodo principal: Lee la IP en la linea de comando para hacer el trace.
     * Ingresar la direccion IP o la palabra exit para finalizar.
     * 
     */
    public static void main(String[] args){

    	System.out.println("Enter the IP address to trace (Or type 'exit' to finish)");
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.next().trim();
        
        while (!input.equalsIgnoreCase("exit")) {
        	
        	if (validate(input)) { 
        		TraceIpResult result = new TraceIpResult();
				try {
					TraceIpCommand command = new TraceIpCommand();
					result = command.execute(input);
					System.out.println(result.toString());
				} catch (UnavailableCountryDataException e) {
					System.out.println("No data available for IP:" + input);
				}
        	} else {
        		System.out.println("Invalid IP.");
        	}
        	
            System.out.println();
            System.out.println("Enter the IP address to trace (Or type 'exit' to finish)");
            input = scanner.next().trim();
        }
        scanner.close();
        System.out.println("Bye!");
    }
    
    /**
     * Valida el formato de una direccion IP.
     * 
     * @param ip la direccion IP
     * @return <true> si la IP tiene formato valido. Retorna <false> en cualquier otro caso.
     */
    public static boolean validate(final String ip) {
    	Pattern pattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        return pattern.matcher(ip).matches();
    }
    
}
