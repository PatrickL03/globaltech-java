
package dependencias;

class EmpleadoDesarrollo extends Empleado {
    private String lenguajePrincipal;

    public EmpleadoDesarrollo(String id, String nombre, double salario, String lenguajePrincipal) {
        super(id, nombre, salario);
        setLenguajePrincipal(lenguajePrincipal);
    }

    public String getLenguajePrincipal() { return lenguajePrincipal; }
    public void setLenguajePrincipal(String lenguajePrincipal) {
        if (lenguajePrincipal != null && !lenguajePrincipal.trim().isEmpty())
            this.lenguajePrincipal = lenguajePrincipal;
        else throw new IllegalArgumentException("Lenguaje inválido.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Lenguaje Principal: " + lenguajePrincipal;
    }
}