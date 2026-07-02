
package dependencias;

abstract class Empleado {
    private String id;
    private String nombre;
    private double salario;

    public Empleado(String id, String nombre, double salario) {
        setId(id);
        setNombre(nombre);
        setSalario(salario);
    }

    // Getters y Setters con validaciones
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID no puede estar vacío.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Nombre no puede estar vacío.");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("El salario debe ser mayor a 0.");
        }
    }

    // Método que será sobrescrito
    public String mostrarInfo() {
        return "ID: " + id + " | Nombre: " + nombre + " | Salario: $" + salario;
    }
}