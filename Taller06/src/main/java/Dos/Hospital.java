
package Dos;


public class Hospital {

    private String nombreH;
    private Ciudad ciudad;
    private int numeroEs;
    private Medicos[] medicos;
    private Enfermeros[] enfermeros;
    private double sueldos;
    private String direccion;

    public Hospital(String a, String b, Ciudad c, int es, Medicos[] m, Enfermeros[] e) {
        nombreH = a;
        direccion = b;
        numeroEs = es;
        ciudad = c;
        medicos = m;
        enfermeros = e;
    }

    public void establecerNombreHospital(String c) {
        nombreH = c;
    }

    public void establecerCiudad(Ciudad c) {
        ciudad = c;
    }

    public void calcularNumeroE() {
        numeroEs = obtenerMedicos().length + obtenerEnfermeros().length;
    }

    public void establecerMedicos(Medicos[] c) {
        medicos = c;
    }

    public void establecerEnfermeros(Enfermeros[] c) {
        enfermeros = c;
    }

    public void calcularSueldo() {
        for (Medicos obtenerMedico : obtenerMedicos()) {
            sueldos = sueldos + obtenerMedico.obtenerSueldo();
        }
        for (Enfermeros obtenerEnfermero : obtenerEnfermeros()) {
            sueldos = sueldos + obtenerEnfermero.obtenerSueldo();
        }
    }

    public void establecerDireccion(String c) {
        direccion = c;
    }

    public String obtenerNombreHospital() {
        return nombreH;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int obtenerNumeroEnfermeros() {
        return numeroEs;
    }

    public Medicos[] obtenerMedicos() {
        return medicos;
    }

    public Enfermeros[] obtenerEnfermeros() {
        return enfermeros;
    }

    public double obtenerSueldo() {
        return sueldos;
    }

    public String obtenerDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        String cadena;
        cadena = String.format("HOSPITAL %s\n"
                + "Dirección: %s\n"
                + "Ciudad: %s\n"
                + "Provincia: %s\n"
                + "Número de especialidades: %d\n",
                obtenerNombreHospital().toUpperCase(),
                obtenerDireccion(),
                obtenerCiudad().obtenerNombre(),
                obtenerCiudad().obtenerProvincia(),
                obtenerNumeroEnfermeros());

        cadena = String.format("%s\nListado de médicos\n", cadena);

        for (Medicos obtenerMedico : obtenerMedicos()) {
            cadena = String.format("%s-%s  - sueldo: %.2f   - %s\n", cadena, obtenerMedico.obtenerNombre(), obtenerMedico.obtenerSueldo(), obtenerMedico.obtenerEspecialidad());
        }

        cadena = String.format("%s\nListado de enfermeros\n", cadena);

        for (Enfermeros obtenerEnfermero : obtenerEnfermeros()) {
            cadena = String.format("%s-%s  - sueldo: %.2f  - %s\n", cadena, obtenerEnfermero.obtenerNombre(), obtenerEnfermero.obtenerSueldo(), obtenerEnfermero.obtenerTipo());
        }

        cadena = String.format("%s\n\nTotal de sueldos a pagar por mes: %.2f", 
                cadena, obtenerSueldo());

        return cadena;

    }

}