package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class Instructores {
    @BsonId
    private ObjectId id;

    private String nombre;
    private String correo;
    private List<String> especialidades;
    private int aniosExperiencia;
    private String bio;
    private Contacto contacto;
    private List<String> cursosId;

    public Instructores() {
    }
    public Instructores(ObjectId id, String nombre, String correo, List<String> especialidades, int aniosExperiencia, String bio, Contacto contacto, List<String> cursosId){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidades = especialidades;
        this.aniosExperiencia = aniosExperiencia;
        this.bio = bio;
        this.contacto = contacto;
        this.cursosId = cursosId;
    }

    public ObjectId get_id() {
        return id;
    }

    public void set_id(ObjectId _id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<String> getCursosId() {
        return cursosId;
    }

    public void setCursosId(List<String> cursosId) {
        this.cursosId = cursosId;
    }
}
