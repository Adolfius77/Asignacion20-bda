package Controllers.impl;

import Controllers.IInstructorController;
import dao.IInstructorDAO;
import Exceptions.DaoException;
import model.Instructores;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InstructorController implements IInstructorController {

    private final IInstructorDAO instructorDAO;

    public InstructorController(IInstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public ObjectId registrarInstructor(Instructores instructor) {
        try {
            return instructorDAO.crearInstructor(instructor);
        } catch (DaoException e) {
            System.err.println("Error al registrar instructor: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Instructores> obtenerPorId(ObjectId id) {
        try {
            return instructorDAO.encontrarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al buscar instructor: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Instructores> listarTodos() {
        try {
            return instructorDAO.encontrarAtodos();
        } catch (DaoException e) {
            System.err.println("Error al listar instructores: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public boolean actualizarInstructor(Instructores instructor) {
        try {
            return instructorDAO.actualizar(instructor);
        } catch (DaoException e) {
            System.err.println("Error al actualizar instructor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarInstructor(ObjectId id) {
        try {
            return instructorDAO.eliminarPorId(id);
        } catch (DaoException e) {
            System.err.println("Error al eliminar instructor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Instructores> buscarPorNombre(String nombre) {
        try {
            return instructorDAO.encontrarPorNombre(nombre);
        } catch (DaoException e) {
            System.err.println("Error al buscar instructor por nombre: " + e.getMessage());
            return Optional.empty();
        }
    }
}