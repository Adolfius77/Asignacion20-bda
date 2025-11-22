package dao;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import model.estudiantes;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IEstudianteDAO {
    ObjectId crearEstudiante(estudiantes entidad)throws DaoException;
    Optional<estudiantes>econtrarPorId(ObjectId _id) throws DaoException;
    List<estudiantes> encontrarTodos() throws DaoException;
    boolean actualizar(estudiantes entidad)throws DaoException;
    boolean eliminarPorId(ObjectId _id)throws DaoException, EntityNotFoundException;
    long borrarTodos() throws DaoException;
    Optional<estudiantes> encontrarPorNombre(String nombre) throws DaoException;

}
