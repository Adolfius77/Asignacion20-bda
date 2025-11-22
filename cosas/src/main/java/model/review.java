package model;

import java.util.Date;

public class review {
    private int rating;
    private String comentario;
    private Date fecha;

    public review() {
    }

    public review(int rating, String comentario, Date fecha) {
        this.rating = rating;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
