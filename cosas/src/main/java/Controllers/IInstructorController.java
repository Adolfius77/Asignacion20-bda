package Controllers;

import model.Instructores;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

public interface IInstructorController {
    ObjectId registrarInstructor(Instructores instructor);
    Optional<Instructores> obtenerPorId(ObjectId id);
    List<Instructores> listarTodos();
    boolean actualizarInstructor(Instructores instructor);
    boolean eliminarInstructor(ObjectId id);
    Optional<Instructores> buscarPorNombre(String nombre);
}