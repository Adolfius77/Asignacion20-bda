package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class estudiantes {
    @BsonId
    private ObjectId _id;

    private String nombre;
    private String correo;
    private cursosMatriculados CursosMatriculados;
    private List<String> intereses;
    private configuraciones Configuraciones;

    public estudiantes() {
    }

    public estudiantes(ObjectId _id, String nombre, String correo, cursosMatriculados cursosMatriculados, List<String> intereses, configuraciones configuraciones) {
        this._id = _id;
        this.nombre = nombre;
        this.correo = correo;
        this.CursosMatriculados = cursosMatriculados;
        this.intereses = intereses;
        this.Configuraciones = configuraciones;

    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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
