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

    private static final int Ruts[] = new int[100];
    private static final float Sueldos[] = new float[100];
    
    private static final int BenefRuts[] = new int[30];
    private static final float BenefSueldos[][] = new float[30][2];
    
    private static Organizado SegunPrecios;
    
    private static void GenerarEmpleados(){
        Random random = new Random();
        
        for (int i = 0 ; i < Ruts.length ; i++){
            Ruts[i] = random.nextInt(100000, 199999);
            Sueldos[i] = random.nextFloat(700000, 2000000);
        }
        
    }
    
    public static void GenerarBono(){
        SegunPrecios = new Organizado(Arrays.copyOf(Sueldos, Sueldos.length),Arrays.copyOf(Ruts, Ruts.length));
        
        float bono = (float) 0.05;
        
        for (int i = 0 ; i < 30 ; i++){
            BenefRuts[i] = SegunPrecios.getRuts()[i];
            BenefSueldos[i][0] = SegunPrecios.getSueldos()[i];
            BenefSueldos[i][1] = BenefSueldos[i][0] * bono;
            Sueldos[i] = BenefSueldos[i][0] + BenefSueldos[i][1];
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros =    {2,1,3,6,7,8,9,5,4,1,2};
        float[] numeros2 = {7,6,4,9,3,4,7,8,1,6,5};
        Organizado Anumeros = new Organizado(Arrays.copyOf(numeros, numeros.length),Arrays.copyOf(numeros2, numeros2.length));
        Organizado Anumeros2 = new Organizado(Arrays.copyOf(numeros2, numeros2.length),Arrays.copyOf(numeros, numeros.length));
        
        System.out.println(Arrays.toString(Anumeros.getRuts()));
        System.out.println(Arrays.toString(Anumeros.getSueldos()));
        
        System.out.println(Arrays.toString(Anumeros2.getRuts()));
        System.out.println(Arrays.toString(Anumeros2.getSueldos()));
    }
    
}
