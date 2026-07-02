
package dependencias;


class EmpleadoLogistica extends Empleado {
    private String turno;

    public EmpleadoLogistica(String id, String nombre, double salario, String turno) {
        super(id, nombre, salario);
        setTurno(turno);
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) {
        if (turno != null && !turno.trim().isEmpty()) this.turno = turno;
        else throw new IllegalArgumentException("Turno inválido.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Turno: " + turno;
    }
}