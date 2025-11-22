package model;

import org.bson.types.ObjectId;

import java.util.List;

public class cursos {
    private ObjectId _id;
    private String titulo;
    private String descripcion;
    private ObjectId instructorId;
    private double precio;
    private double rating;
    private List<String> tags;
    private modulos modulo;

    public cursos() {
    }
    public cursos(ObjectId _id, String titulo, String descripcion, ObjectId instructorId, double precio, double rating, List<String> tags, modulos modulo){
        this._id = _id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.instructorId = instructorId;
        this.precio = precio;
        this.rating = rating;
        this.tags = tags;
        this.modulo = modulo;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObjectId getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(ObjectId instructorId) {
        this.instructorId = instructorId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public modulos getModulo() {
        return modulo;
    }

    public void setModulo(modulos modulo) {
        this.modulo = modulo;
    }

}
