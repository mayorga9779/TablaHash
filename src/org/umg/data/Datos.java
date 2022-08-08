/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.data;

import org.umg.hash.DispersionHash;

/**
 *
 * @author Edgar Mayorga
 */
public class Datos {
    private String[] datos;
    private String[] tablaHash;
    private String[] tablaAux;
    private int totalRegistros;
    private int tamanioHash;
    private int iteracion;
    private String codigoCurso;
    private String nombreCurso;
    private float precioCurso;
    private Lista listaCursos;
    private DispersionHash hash = new DispersionHash();
    
    public Datos(){
        totalRegistros = 40;
        tamanioHash = 50;
        datos = new String[totalRegistros];
        tablaHash = new String[tamanioHash];
        tablaAux = new String[tamanioHash];
        iteracion = 700;
        codigoCurso = "";
        nombreCurso = "";
        precioCurso = 0;
        listaCursos = null;
    }
    
    public void cargarDatos(){
        listaCursos = new Lista();
        String parteEntera = "";
        String parteDecimal = "";
        
        for(int i = 0; i < totalRegistros; i++){
            codigoCurso = "CA-" + (iteracion + i) + "A";
            nombreCurso = "Curso " + codigoCurso;
            parteEntera = codigoCurso.substring(3, 6);
            parteDecimal = parteEntera.substring(1, 3);
            precioCurso = Float.parseFloat(parteEntera + "." + parteDecimal);
            
            listaCursos.agregarAlFinal(codigoCurso, nombreCurso, precioCurso);
        }
    }
    
    
    public void cargarDatosEnHash() throws Exception{
        long indiceHash = 0;
        int nuevoIndice = 0;
        String clave = "";
        
        System.out.println("Longitud hash: " + tablaHash.length);
        
        if(!listaCursos.esVacia()){
            for(int i = 0; i < longitudLista(); i++){
                clave = retornaClave(i);
                indiceHash = hash.transformaCadena(clave);
                indiceHash = hash.dispersion(indiceHash);
                
                if(entradaHashVacio((int)indiceHash) == true){      //si esta vacio
                    tablaHash[(int)indiceHash] = clave;             //guardo el codigoCurso en el indice calculado para la tabla hash
                    tablaAux[(int)indiceHash] = clave + ", " + (int)indiceHash + " <-- índice calculado";
                }else{
                    //lo que entra aqui, es porque hubo colision.
                    //utilizo metodo de exploracion linea para guardar la clave, esto debido a las colisiones.
                    nuevoIndice = exploracionLinealHash((int)indiceHash);
                    tablaHash[nuevoIndice] = clave;
                    tablaAux[(int)indiceHash] = clave + "*, " + (int)indiceHash + " <-- nuevo índice calculado";
                }
            }
        }
    }
    
    public int exploracionLinealHash(int indiceHashActual){
        int indice = 0;
        
        for(int i = indiceHashActual; i < longitudLista(); i++){
            if(entradaHashVacio(i) == true){
                indice = i;
                break;
            }
        }
        
        return indice;
    }
    
    public boolean entradaHashVacio(int indiceHash){
        boolean retorna = false;
        String clave = "";
        
        try{
            //clave = tablaHash[indiceHash].toString();
            //Si el espacio de indicado del array esta vacio, retorna true, si esta lleno, retorna false
            if(tablaHash[indiceHash] == null){
                retorna = true;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        return retorna;
    }
    
    public void mostrarDatos(){
        listaCursos.visualizarLista();
    }
    
    public void mostrarDatosHash() throws Exception{
        String precioCurso = "";
        
        System.out.println("INDICE,  CÓDIGO,         NOMBRE,           PRECIO");
        for(int i = 0; i < tamanioHash; i++){
            if(tablaHash[i] == null){
                tablaHash[i] = "";
            }
            if(listaCursos.getPrecioCurso(i) == 0){
                precioCurso = "";
            }else{
                precioCurso = String.valueOf(listaCursos.getPrecioCurso(i));
            }
            if(tablaHash[i].equals("")){
                System.out.println(i + ", Libre");
            }else{
                System.out.println(i + ",       " + tablaHash[i].toString() + ",        Curso " + tablaHash[i].toString() + ",    " + precioCurso);
            }
        }
    }
    
    public void mostrarDatosHashAux(){
        System.out.println("CODIGO,  ÍNDICE");
        for(int i = 0; i < tamanioHash; i++){
            if(tablaAux[i] != null){
                //System.out.println("Clave: " + tablaAux[i].toString() + " Indice: " + i);
                System.out.println(tablaAux[i].toString());
            }
        }
    }
    
    public int longitudLista(){
        return listaCursos.getLongitud();
    }
    
    public String retornaClave(int posicion) throws Exception{
        return listaCursos.getCodigoCurso(posicion);
    }
    
    public int tamanioArray(){
        return datos.length;
    }
}
