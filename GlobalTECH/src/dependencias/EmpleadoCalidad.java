
package dependencias;


class EmpleadoCalidad extends Empleado {
    private String norma;

    public EmpleadoCalidad(String id, String nombre, double salario, String norma) {
        super(id, nombre, salario);
        setNorma(norma);
    }

    public String getNorma() { return norma; }
    public void setNorma(String norma) {
        if (norma != null && !norma.trim().isEmpty()) this.norma = norma;
        else throw new IllegalArgumentException("Norma inválida.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Norma: " + norma;
    }
}