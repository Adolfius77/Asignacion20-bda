package model;

public class Contacto {
    private String telefono;
    private String Linkedin;
    private String website;

    public Contacto() {
    }

    public Contacto(String telefono,String linkedin,String website) {
        this.telefono = telefono;
        this.Linkedin = linkedin;
        this.website = website;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinkedin() {
        return Linkedin;
    }

    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
