
package dependencias;


class EmpleadoMarketing extends Empleado {
    private String canal;

    public EmpleadoMarketing(String id, String nombre, double salario, String canal) {
        super(id, nombre, salario);
        setCanal(canal);
    }

    public String getCanal() { return canal; }
    public void setCanal(String canal) {
        if (canal != null && !canal.trim().isEmpty()) this.canal = canal;
        else throw new IllegalArgumentException("Canal inválido.");
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Canal: " + canal;
    }
}