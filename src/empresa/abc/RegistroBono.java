/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.abc;

/**
 *
 * @author HP PORTATIL
 */
public class RegistroBono {
    private int Ruts[] = new int[30];
    private float SueldosOriginales[] = new float[30];
    private float Aumentos[] = new float[30];
    private float SueldosTotales[] = new float[30];

    public RegistroBono() {
    }

    public RegistroBono(int[] Ruts, float[] SueldosOriginales, float[] Aumentos, float[] SueldosTotales) {
        this.Ruts = Ruts;
        this.SueldosOriginales = SueldosOriginales ;
        this.Aumentos = Aumentos ;
        this.SueldosTotales = SueldosTotales ;
    }
    
    public int[] getRuts() {
        return Ruts;
    }

    public float[] getSueldosOriginales() {
        return SueldosOriginales;
    }

    public float[] getAumentos() {
        return Aumentos;
    }

    public float[] getSueldosTotales() {
        return SueldosTotales;
    }
    
    
}
