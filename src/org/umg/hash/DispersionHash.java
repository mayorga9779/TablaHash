/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.hash;

/**
 *
 * @author Edgar Mayorga
 */
public class DispersionHash {
    static final int M = 50;
    static final double R = 0.618034;
    
    public long transformaCadena(String clave){
        long d = 0;
        
        for(int j = 0; j < Math.min(clave.length(), 10); j++){
            d = d * 27 + (int)clave.charAt(j);
        }
        
        if(d < 0){
            d = -d;
        }
        
        return d;
    }
    
    //Metodo de la multiplicacion
    public int dispersion(long x){
        double t;
        int v;
        
        t = R * x - Math.floor(R * x);
        v = (int)(M * t);
        
        return v;
    }
}
