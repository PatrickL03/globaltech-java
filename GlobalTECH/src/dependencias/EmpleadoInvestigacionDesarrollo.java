
package dependencias;


class EmpleadoInvestigacionDesarrollo extends Empleado {
    private String proyecto;

    public EmpleadoInvestigacionDesarrollo(String id, String nombre, double salario, String proyecto) {
        super(id, nombre, salario);
        setProyecto(proyecto);
    }

    public String getProyecto() { return proyecto; }
    public void setProyecto(String proyecto) {
        if (proyecto != null && !proyecto.trim().isEmpty()) this.proyecto = proyecto;
        else throw new IllegalArgumentException("Proyecto inválido.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Proyecto: " + proyecto;
    }
}