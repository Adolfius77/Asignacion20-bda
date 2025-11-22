package model;

public class configuraciones {
    private boolean notificaciones;
    private boolean modoOscuro;
    private String lenguaje;

    public configuraciones() {
    }

    public configuraciones(boolean notificaciones, boolean modoOscuro, String lenguaje) {
        this.notificaciones = notificaciones;
        this.modoOscuro = modoOscuro;
        this.lenguaje = lenguaje;

    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public boolean isModoOscuro() {
        return modoOscuro;
    }

    public void setModoOscuro(boolean modoOscuro) {
        this.modoOscuro = modoOscuro;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
}
