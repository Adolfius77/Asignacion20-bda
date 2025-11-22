package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class estudiantes {
    @BsonId
    private ObjectId id;

    private String nombre;
    private String correo;
    private cursosMatriculados CursosMatriculados;
    private List<String> intereses;
    private configuraciones Configuraciones;

    public estudiantes() {
    }

    public estudiantes(ObjectId id, String nombre, String correo, cursosMatriculados cursosMatriculados, List<String> intereses, configuraciones configuraciones) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.CursosMatriculados = cursosMatriculados;
        this.intereses = intereses;
        this.Configuraciones = configuraciones;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public cursosMatriculados getCursosMatriculados() {
        return CursosMatriculados;
    }

    public void setCursosMatriculados(cursosMatriculados cursosMatriculados) {
        CursosMatriculados = cursosMatriculados;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public configuraciones getConfiguraciones() {
        return Configuraciones;
    }

    public void setConfiguraciones(configuraciones configuraciones) {
        Configuraciones = configuraciones;
    }
}
