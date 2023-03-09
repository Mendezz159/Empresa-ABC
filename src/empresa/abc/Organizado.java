/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.abc;

import java.util.ArrayList;

/**
 *
 * @author HP PORTATIL
 */
public class Organizado {
    
    private int Ruts[];
    private float Sueldos[];
    private int PrincipalIndice;

    public int[] getRuts() {
        return Ruts;
    }

    public float[] getSueldos() {
        return Sueldos;
    }
    
    /**
     * 
     * @param Principal El arreglo que se va a ordenar
     * @param Segundario El arreglo que seguira los movimientos del principal
     */
    public Organizado (int[] Principal, float[] Segundario){
        this.PrincipalIndice=0;
        this.Ruts=Principal;
        this.Sueldos=Segundario;
        QuicksortArray(Principal, 0, Principal.length-1);
        
    }
    
    public Organizado (float[] Principal, int[] Segundario){
        this.PrincipalIndice=1;
        this.Sueldos=Principal;
        this.Ruts=Segundario;
        QuicksortArray(Principal, 0, Principal.length-1);
        
    }
    
    private void QuicksortArray(int[] Principal, int izquierda, int derecha){
        if(izquierda >= derecha){
            return;
        }
        
        int i = izquierda-1;
        for(int j = izquierda; j < derecha ; j++){
            if(Principal[j]<Principal[derecha]){
                i++;
                this.Intercambiar(i,j);
                Principal=this.Ruts;
            }
        }
        i++;
        this.Intercambiar(i,derecha);
        Principal=this.Ruts;
        
        this.QuicksortArray(Principal, izquierda, i-1);
        this.QuicksortArray(Principal, i+1, derecha);
    }
    
    private void QuicksortArray(float[] Principal, int izquierda, int derecha){
        if(izquierda >= derecha){
            return;
        }
        
        int i = izquierda-1;
        for(int j = izquierda; j < derecha ; j++){
            if(Principal[j]<Principal[derecha]){
                i++;
                this.Intercambiar(i,j);
                Principal=this.Sueldos;
            }
        }
        i++;
        this.Intercambiar(i,derecha);
        Principal=this.Sueldos;
        
        this.QuicksortArray(Principal, izquierda, i-1);
        this.QuicksortArray(Principal, i+1, derecha);
    }
    
    private void Intercambiar(int i, int j){
        
        int tempoInt = this.Ruts[i]; float tempoFloat = this.Sueldos[i];
        this.Ruts[i] = this.Ruts[j]; this.Sueldos[i] = this.Sueldos[j];
        this.Ruts[j] = tempoInt; this.Sueldos[j] = tempoFloat;

    }
}
