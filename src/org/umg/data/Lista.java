/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.umg.data;

/**
 *
 * @author Edgar Mayorga
 */
public class Lista {
    protected NodoCurso ultimo;
    private NodoCurso inicio;
    private int tamanio;
    
    public Lista(){
        ultimo = null;
        inicio = null;
        tamanio = 0;
    }
    
    public void agregarAlFinal(String codigoCurso, String nombreCurso, float precioCurso){
        NodoCurso nuevo = new NodoCurso(codigoCurso, nombreCurso, precioCurso);
        
        if (esVacia()) {
            inicio = nuevo;
        } else{
            NodoCurso aux = inicio;
            
            while(aux.getEnlace() != null){
                aux = aux.getEnlace();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setEnlace(nuevo);
        }
        
        tamanio++;
    }
    
    public String getCodigoCurso(int posicion) throws Exception{
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if(posicion>=0 && posicion<tamanio){
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getCodigoCurso();
            }else{
                // Crea una copia de la lista.
                NodoCurso aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getEnlace();
                }
                // Retorna el valor del nodo.
                return aux.getCodigoCurso();
            }
        // Crea una excepción de Posicion inexistente en la lista.
        } else {
            throw new Exception("Posicion inexistente en la lista. CODIGOCURSO");
        }
    }
    
    public float getPrecioCurso(int posicion){
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        float retorna = 0;
        
        if(posicion >= 0 && posicion < tamanio){
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getPrecioCurso();
            }else{
                // Crea una copia de la lista.
                NodoCurso aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getEnlace();
                }
                // Retorna el valor del nodo.
                retorna = aux.getPrecioCurso();
                return retorna;
            }
        // Crea una excepción de Posicion inexistente en la lista.
        } else {
            //throw new Exception("Posicion inexistente en la lista PRECIO.");
            return retorna;
        }
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getLongitud(){
        return tamanio;
    }
    
    public void visualizarLista(){
        NodoCurso n;
        int k = 0;
        
        n = inicio;
        
        while(n != null){
            System.out.println("Codigo: " + n.getCodigoCurso() + " Curso: " + n.getNombreCurso() + " Precio: " + n.getPrecioCurso());
            n = n.getEnlace();
            k++;
        }
    }
}
