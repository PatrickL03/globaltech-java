
package dependencias;

class EmpleadoRecursosHumanos extends Empleado {
    private String especialidad;

    public EmpleadoRecursosHumanos(String id, String nombre, double salario, String especialidad) {
        super(id, nombre, salario);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) {
        if (especialidad != null && !especialidad.trim().isEmpty()) this.especialidad = especialidad;
        else throw new IllegalArgumentException("Especialidad inválida.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Especialidad: " + especialidad;
    }
}