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
public class NodoCurso {
    private String codigoCurso;
    private String nombreCurso;
    private float precioCurso;
    private NodoCurso enlace;
    
    public NodoCurso(String codigoCurso, String nombreCurso, float precioCurso){
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.precioCurso = precioCurso;
        this.enlace = null;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public float getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(float precioCurso) {
        this.precioCurso = precioCurso;
    }

    public NodoCurso getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoCurso enlace) {
        this.enlace = enlace;
    }
}
