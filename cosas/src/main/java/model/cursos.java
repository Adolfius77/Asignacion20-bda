package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class cursos {
    @BsonId
    private ObjectId id;

    private String titulo;
    private String descripcion;
    private ObjectId instructorId;
    private double precio;
    private double rating;
    private List<String> tags;
    private modulos modulo;
    private Date createdAt;
    private Date updatedAt;

    public cursos() {
    }
    public cursos(ObjectId id, String titulo, String descripcion, ObjectId instructorId, double precio, double rating, List<String> tags, modulos modulo, Date createdAt, Date updatedAt){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.instructorId = instructorId;
        this.precio = precio;
        this.rating = rating;
        this.tags = tags;
        this.modulo = modulo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
