/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresa.abc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author HP PORTATIL
 */
public class EmpresaABC {

    private final int Ruts[] = new int[100];
    private final float Sueldos[] = new float[100];
    
    //metodo para generar los ruts y sueldos
    private void GenerarEmpleados(){
        Random random = new Random();
        
        for (int i = 0 ; i < Ruts.length ; i++){
            Ruts[i] = random.nextInt(100000, 199999);
            Sueldos[i] = random.nextFloat(700000, 2000000);
        }
        
    }
    
    //Genera un bono
    public RegistroBono GenerarBono(){
        Organizado SegunPrecios = new Organizado(Arrays.copyOf(Sueldos, Sueldos.length),Arrays.copyOf(Ruts, Ruts.length));
        
        int Ruts[] = new int[30];
        float[] SueldosOriginales, Aumentos, SueldosTotales;
        
        SueldosOriginales = new float[30];
        Aumentos = new float[30];
        SueldosTotales = new float[30];
        
        float bono = (float) 0.05;
        
        for (int i = 0 ; i < 30 ; i++){
            
            Ruts[i] = SegunPrecios.getRuts()[i];
            SueldosOriginales[i] = SegunPrecios.getSueldos()[i];
            Aumentos[i] = SueldosOriginales[i] * bono;
            SueldosTotales[i] = SueldosOriginales[i] + Aumentos[i];
            
            Sueldos[i] = SueldosOriginales[i] + Aumentos[i];
        }
        
        RegistroBono registro = new RegistroBono(Ruts, SueldosOriginales, Aumentos, SueldosTotales);
        
        return registro;
    }

    public int[] getRuts() {
        return Ruts;
    }

    public float[] getSueldos() {
        return Sueldos;
    }
    
    public EmpresaABC(){
        GenerarEmpleados();
    }
       
}
