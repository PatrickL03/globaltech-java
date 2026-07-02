
package dependencias;


class EmpleadoFinanzas extends Empleado {
    private String areaContable;

    public EmpleadoFinanzas(String id, String nombre, double salario, String areaContable) {
        super(id, nombre, salario);
        setAreaContable(areaContable);
    }

    public String getAreaContable() { return areaContable; }
    public void setAreaContable(String areaContable) {
        if (areaContable != null && !areaContable.trim().isEmpty()) this.areaContable = areaContable;
        else throw new IllegalArgumentException("Área contable inválida.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Área contable: " + areaContable;
    }
}