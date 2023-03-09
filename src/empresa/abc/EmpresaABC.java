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

    private int Ruts[] = new int[100];
    private float Sueldos[] = new float[100];
    
    //metodo para generar los ruts y sueldos
    private void GenerarEmpleados(){
        Random random = new Random();
        
        Ruts=this.ArrayUnicoAleatoreo(Ruts.length, 100000, 999999);
        for (int i = 0 ; i < Ruts.length ; i++){
            Sueldos[i] = random.nextFloat(700000, 2000000);
        }
        
        Organizado SegunRuts = new Organizado(Arrays.copyOf(Ruts, Ruts.length),Arrays.copyOf(Sueldos, Sueldos.length));
        
        Ruts= SegunRuts.getRuts();
        Sueldos= SegunRuts.getSueldos();
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
            
            Sueldos[indiceRut(Ruts[i])] = SueldosOriginales[i] + Aumentos[i];
        }
        
        RegistroBono registro = new RegistroBono(Ruts, SueldosOriginales, Aumentos, SueldosTotales);
        
        return registro;
    }

    public ArrayList<Integer> BuscarUsuario(int numero){
        
        ArrayList<Integer> Indices = new ArrayList<>();
        int DigitosNum = Digitos(numero);
        
        for(int i = 0 ; i < Ruts.length ; i++){
            if(DigitosNum<=Digitos(Ruts[i]) && numero == UltimosDigitos(Ruts[i] , DigitosNum)){
                Indices.add(i);
            }
        }
        
        return Indices;
    }
    
    private int Digitos(int numero){
        String numeroComoString = String.valueOf(numero);
        int cantidadDigitos = numeroComoString.length();
        
        return cantidadDigitos;
    }
    
    private int UltimosDigitos(int numero, int digitos){
        
        String numeroString = String.valueOf(numero);
        numeroString = numeroString.substring(0, digitos);
        int ultimosDigitos = Integer.parseInt(numeroString);
        
        return ultimosDigitos;
    }
    
    private int indiceRut(int rut){
        return this.BuscarInt(Ruts, rut, 0, Ruts.length);
    }
    
    /**
     * metodo de busqueda binaria para conseguir el indice del numero buscado
     * 
     * @param Arreglo el arreglo en el que se quiere buscar el numero
     * @param numero el numero a buscar
     * @param izquierda limite minimo del segmento del areglo en la que se busca
     * @param derecha limite maximo del segmento del areglo en la que se busca
     * @return indice en donde se encuentra el numero (retornara -1 si no lo encuentra)
     */
    private int BuscarInt(int[] Arreglo, int numero, int izquierda, int derecha){
        
        int centro = izquierda + ((derecha-izquierda)/2);
        
        if(izquierda > derecha){
            return -1;
        }
        
        if(Arreglo[centro] == numero){
            return centro;
        }else if(izquierda == derecha){
            return -1;
        }else if(Arreglo[centro] < numero){
            return BuscarInt(Arreglo,numero,centro+1,derecha);
        }else{
            return BuscarInt(Arreglo,numero,izquierda,centro-1);
        }
        
    }
    
    /**
     * genera un arreglo con datos aleatoreos que no se repiten
     * 
     * @param tamaño Tamaño del arreglo
     * @param NumeroMinimo el dato mas pequeño que puede ser generado aleatoreamente
     * @param NumeroMaximo el dato mas grande que puede ser generado aleatoreamente
     * @return un arreglo int con las caracteristicas pedidas
     */
    private int[] ArrayUnicoAleatoreo(int tamaño, int NumeroMinimo, int NumeroMaximo){
        int[] array = new int[tamaño];
        Random random = new Random();
        
        for(int i = 0 ; i < tamaño ; i++){
            
            boolean NumeroExistente;
            
            do{
                int nuevoNum = random.nextInt(NumeroMinimo, NumeroMaximo);
                
                if(BuscarInt(array , nuevoNum , 0 , i-1) == -1){
                    NumeroExistente = false;
                    array[i]=nuevoNum;
                }else{
                    NumeroExistente = true;
                }
            }while(NumeroExistente);
        }
        
        return array;
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
