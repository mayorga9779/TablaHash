/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.principal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.umg.data.Datos;
import org.umg.hash.DispersionHash;

/**
 *
 * @author Edgar Mayorga
 */
public class Main {
    
    
    public static void main(String[] args) throws Exception{
        Datos datos = new Datos();
        DispersionHash hash = new DispersionHash();
        String clave = "";
        long valor = 0;
        
        System.out.println("DATOS DE ESTUDIANTE");
        try{
            System.out.println("==================================================");
            System.out.println("5190-05-407, MYNOR ADÁN LÓPEZ IZAGUIRRE, SECCION A");
            System.out.println("" + InetAddress.getLocalHost());
            System.out.println("==================================================");
            System.out.println();
        }catch(UnknownHostException ex){
            //Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("CARGANDO DATOS...");
        datos.cargarDatos();
        datos.mostrarDatos();
        System.out.println();
        System.out.println("Total de datos cargados: " + datos.longitudLista());
        System.out.println();
        System.out.println();
        System.out.println("TABLA HASH CALCULO INDICES");
        datos.cargarDatosEnHash();
        datos.mostrarDatosHashAux();
        System.out.println();
        System.out.println();
        System.out.println("TABLA HASH");
        datos.mostrarDatosHash();
        /*System.out.println("Indices calculados");
        for(int i = 0; i < datos.longitudLista(); i++){
            clave = datos.retornaClave(i);
            //System.out.println("Clave a dispersar: " + clave);
            valor = hash.transformaCadena(clave);
            valor = hash.dispersion(valor);
            System.out.println("Dispersion de la clave: " + clave + " valor: " + valor);
        }*/
    }
}
