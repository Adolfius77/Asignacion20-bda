package dao;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import model.Instructores;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IInstructorDAO {
    ObjectId crearInstructor(Instructores entidad)throws DaoException;
    Optional<Instructores>encontrarPorId(ObjectId _id) throws DaoException;
    List<Instructores> encontrarAtodos()throws DaoException;
    Boolean actualizar(Instructores entidad)throws DaoException;
    boolean eliminarPorId(ObjectId _id)throws DaoException, EntityNotFoundException;
    long borrarTodos() throws DaoException;
    Optional<Instructores> encontrarPorNombre(String nombre) throws DaoException;
}
