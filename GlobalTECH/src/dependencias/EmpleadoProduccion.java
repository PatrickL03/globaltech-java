
package dependencias;


class EmpleadoProduccion extends Empleado {
    private String linea;

    public EmpleadoProduccion(String id, String nombre, double salario, String linea) {
        super(id, nombre, salario);
        setLinea(linea);
    }

    public String getLinea() { return linea; }
    public void setLinea(String linea) {
        if (linea != null && !linea.trim().isEmpty()) this.linea = linea;
        else throw new IllegalArgumentException("Línea inválida.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Línea: " + linea;
    }
}