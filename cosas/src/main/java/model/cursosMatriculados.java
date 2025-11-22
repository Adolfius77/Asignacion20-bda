package model;

import org.bson.types.ObjectId;

import java.util.Date;

public class cursosMatriculados {
    private ObjectId cursoId;
    private Date enrollmentDate;
    private Double progreso;
    private review review;

    public cursosMatriculados() {
    }

    public cursosMatriculados(ObjectId cursoId, Date enrollmentDate, Double progreso, review review) {
        this.cursoId = cursoId;
        this.enrollmentDate = enrollmentDate;
        this.progreso = progreso;
        this.review = review;
    }

    public ObjectId getCursoId() {
        return cursoId;
    }

    public void setCursoId(ObjectId cursoId) {
        this.cursoId = cursoId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getProgreso() {
        return progreso;
    }

    public void setProgreso(Double progreso) {
        this.progreso = progreso;
    }

    public model.review getReview() {
        return review;
    }

    public void setReview(model.review review) {
        this.review = review;
    }
}
