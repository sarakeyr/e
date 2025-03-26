package com.iescamp;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Usuario {
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate f_echanacimiento;
    private String pass;
    private boolean activo;

    public Usuario(String dni, String nombre, String apellidos, String direccion, String telefono, String correoElectronico, LocalDate f_echanacimiento, String pass, boolean activo) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setEmail(correoElectronico);
        this.setF_echanacimiento(f_echanacimiento);
        this.setPass(pass);
        this.setActivo(activo);
    }

    public String getDni() { return dni; }
    public void setDni(String dni) {
        if (dni == null || dni.isEmpty() || !dni.matches("\\d{8}[A-Za-z]")) {
            throw new IllegalArgumentException("El DNI debe contener 8 números seguidos de una letra");
        }
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.isEmpty()) {
            throw new IllegalArgumentException("Los apellidos no pueden estar vacíos");
        }
        this.apellidos = apellidos;
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        this.telefono = telefono;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío");
        }
        this.email = email;
    }

    public LocalDate getF_echanacimiento() { return f_echanacimiento; }
    public void setF_echanacimiento(LocalDate f_echanacimiento) {
        if (f_echanacimiento == null || f_echanacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no es válida");
        }
        this.f_echanacimiento = f_echanacimiento;
    }

    public String getPass() { return pass; }
    public void setPass(String pass) {
        if (pass == null || pass.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
        this.pass = pass;
    }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return activo == usuario.activo &&
                Objects.equals(dni, usuario.dni) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellidos, usuario.apellidos) &&
                Objects.equals(direccion, usuario.direccion) &&
                Objects.equals(telefono, usuario.telefono) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(f_echanacimiento, usuario.f_echanacimiento) &&
                Objects.equals(pass, usuario.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellidos, direccion, telefono, email, f_echanacimiento, pass, activo);
    }

    @Override
    public String toString() {
        return "- Usuario -\n" +
                "\tDNI               : " + dni + "\n" +
                "\tNombre            : " + nombre + "\n" +
                "\tApellidos         : " + apellidos + "\n" +
                "\tDirección         : " + direccion + "\n" +
                "\tTeléfono          : " + telefono + "\n" +
                "\tCorreo Electrónico: " + email + "\n" +
                "\tFecha Nacimiento  : " + f_echanacimiento + "\n" +
                "\tActivo            : " + (activo ? "Sí" : "No") + "\n";
    }
}
