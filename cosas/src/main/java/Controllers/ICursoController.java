package Controllers;

import model.cursos;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

public interface ICursoController {
    ObjectId crearCurso(cursos curso);
    Optional<cursos> obtenerPorId(ObjectId id);
    List<cursos> listarTodos();
    boolean actualizarCurso(cursos curso);
    boolean eliminarCurso(ObjectId id);
    Optional<cursos> buscarPorTitulo(String titulo);
}