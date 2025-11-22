package model;

public class resources {
    private String tipo;
    private String titulo;
    private String url;

    public resources() {
    }
    public resources(String tipo, String titulo, String url) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

