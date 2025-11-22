package dao;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import model.cursos;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ICursoDAO {
    ObjectId crearCurso(cursos entidad)throws DaoException;
    Optional<cursos>encontrarPorId(ObjectId _id)throws DaoException;
    List<cursos> encontrarTodos()throws DaoException;
    boolean actualizar(cursos entidad)throws DaoException;
    boolean eliminarPorId(ObjectId _id)throws DaoException, EntityNotFoundException;
    long borrarTodos() throws DaoException;
    Optional<cursos> encontrarPorTitulo(String titulo) throws DaoException;

}
