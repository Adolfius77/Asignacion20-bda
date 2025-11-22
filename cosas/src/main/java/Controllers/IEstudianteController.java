package Controllers;

import model.estudiantes;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

public interface IEstudianteController {
    ObjectId registrarEstudiante(estudiantes estudiante);
    Optional<estudiantes> obtenerPorId(ObjectId id);
    List<estudiantes> listarTodos();
    boolean actualizarEstudiante(estudiantes estudiante);
    boolean eliminarEstudiante(ObjectId id);
    Optional<estudiantes> buscarPorNombre(String nombre);
}