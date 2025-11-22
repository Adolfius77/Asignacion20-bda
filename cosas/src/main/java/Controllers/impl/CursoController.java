package Controllers.impl;

import Controllers.ICursoController;
import dao.ICursoDAO;
import Exceptions.DaoException;
import model.cursos;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CursoController implements ICursoController {

    private final ICursoDAO cursoDAO;

    public CursoController(ICursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    @Override
    public ObjectId crearCurso(cursos curso) {
        try {
            if (curso.getTitulo() == null || curso.getTitulo().isEmpty()) {
                System.err.println("Error: El curso debe tener un título.");
                return null;
            }
            return cursoDAO.crearCurso(curso);
        } catch (DaoException e) {
            System.err.println("Error al crear curso: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<cursos> obtenerPorId(ObjectId id) {
        try {
            return cursoDAO.encontrarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al obtener curso: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<cursos> listarTodos() {
        try {
            return cursoDAO.encontrarTodos();
        } catch (DaoException e) {
            System.err.println("Error al listar cursos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public boolean actualizarCurso(cursos curso) {
        try {
            return cursoDAO.actualizar(curso);
        } catch (DaoException e) {
            System.err.println("Error al actualizar curso: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCurso(ObjectId id) {
        try {
            return cursoDAO.eliminarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al eliminar curso: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<cursos> buscarPorTitulo(String titulo) {
        try {
            return cursoDAO.encontrarPorTitulo(titulo);
        } catch (DaoException e) {
            System.err.println("Error al buscar curso por título: " + e.getMessage());
            return Optional.empty();
        }
    }
}