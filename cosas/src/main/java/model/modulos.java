package model;

public class modulos {
    private String moduloTitulo;
    private int duracionMinutos;
    private resources recursos;

    public modulos() {
    }
    public modulos(String moduloTitulo, int duracionMinutos, resources recursos) {
        this.moduloTitulo = moduloTitulo;
        this.duracionMinutos = duracionMinutos;
        this.recursos = recursos;

    }

    public String getModuloTitulo() {
        return moduloTitulo;
    }

    public void setModuloTitulo(String moduloTitulo) {
        this.moduloTitulo = moduloTitulo;
    }
}
