package Controllers.impl;

import Controllers.IEstudianteController;
import dao.IEstudianteDAO;
import Exceptions.DaoException;
import model.estudiantes;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EstudianteController implements IEstudianteController {

    private final IEstudianteDAO estudianteDAO;

    public EstudianteController(IEstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    @Override
    public ObjectId registrarEstudiante(estudiantes estudiante) {
        try {
            return estudianteDAO.crearEstudiante(estudiante);
        } catch (DaoException e) {
            System.err.println("Error al registrar estudiante: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<estudiantes> obtenerPorId(ObjectId id) {
        try {
            return estudianteDAO.econtrarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al buscar estudiante: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<estudiantes> listarTodos() {
        try {
            return estudianteDAO.encontrarTodos();
        } catch (DaoException e) {
            System.err.println("Error al listar estudiantes: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public boolean actualizarEstudiante(estudiantes estudiante) {
        try {
            return estudianteDAO.actualizar(estudiante);
        } catch (DaoException e) {
            System.err.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarEstudiante(ObjectId id) {
        try {
            return estudianteDAO.eliminarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<estudiantes> buscarPorNombre(String nombre) {
        try {
            return estudianteDAO.encontrarPorNombre(nombre);
        } catch (DaoException e) {
            System.err.println("Error al buscar estudiante por nombre: " + e.getMessage());
            return Optional.empty();
        }
    }
}