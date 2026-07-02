
package dependencias;

class EmpleadoVentas extends Empleado {
    private double comision;

    public EmpleadoVentas(String id, String nombre, double salario, double comision) {
        super(id, nombre, salario);
        setComision(comision);
    }

    public double getComision() { return comision; }
    public void setComision(double comision) {
        if (comision >= 0) this.comision = comision;
        else throw new IllegalArgumentException("Comisión no válida.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Comisión: $" + comision;
    }
}