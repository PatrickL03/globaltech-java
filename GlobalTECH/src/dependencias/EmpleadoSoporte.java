
package dependencias;

class EmpleadoSoporte extends Empleado {
    private String nivel;

    public EmpleadoSoporte(String id, String nombre, double salario, String nivel) {
        super(id, nombre, salario);
        setNivel(nivel);
    }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) {
        if (nivel != null && !nivel.trim().isEmpty()) this.nivel = nivel;
        else throw new IllegalArgumentException("Nivel inválido.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Nivel: " + nivel;
    }
}