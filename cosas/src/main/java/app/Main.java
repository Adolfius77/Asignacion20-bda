package app;

import config.MongoClientProvider;
import Controllers.ICursoController;
import Controllers.IEstudianteController;
import Controllers.IInstructorController;
import Controllers.impl.CursoController;
import Controllers.impl.EstudianteController;
import Controllers.impl.InstructorController;
import dao.ICursoDAO;
import dao.IEstudianteDAO;
import dao.IInstructorDAO;
import dao.impl.EstudianteDAO;
import dao.impl.cursoDAO;
import dao.impl.instructoresDAO;
import model.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA LEARN UP ===");


        try {
            MongoClientProvider.INSTANCE.init();
            System.out.println("[INFO] Conexión a base de datos establecida.");
        } catch (Exception e) {
            System.err.println("[ERROR] Fallo al conectar con Mongo: " + e.getMessage());
            return;
        }


        ICursoDAO cursoDAO = new cursoDAO(
                MongoClientProvider.INSTANCE.getcCollection("courses", cursos.class)
        );
        ICursoController cursoController = new CursoController(cursoDAO);

        IInstructorDAO instructorDAO = new instructoresDAO(
                MongoClientProvider.INSTANCE.getcCollection("instructors", Instructores.class)
        );
        IInstructorController instructorController = new InstructorController(instructorDAO);

        IEstudianteDAO estudianteDAO = new EstudianteDAO(
                MongoClientProvider.INSTANCE.getcCollection("students", estudiantes.class)
        );
        IEstudianteController estudianteController = new EstudianteController(estudianteDAO);





        ObjectId idInstructor = probarCicloInstructor(instructorController);


        ObjectId idProfesorParaCurso = (idInstructor != null) ? idInstructor : new ObjectId();
        ObjectId idCurso = probarCicloCurso(cursoController, idProfesorParaCurso);


        probarCicloEstudiante(estudianteController, idCurso);

        System.out.println("\n=== PRUEBAS FINALIZADAS ===");

        System.exit(0);
    }


    private static ObjectId probarCicloCurso(ICursoController controller, ObjectId instructorId) {
        System.out.println("\n--- [TEST] INICIANDO CRUD DE CURSOS ---");


        cursos nuevoCurso = new cursos();
        nuevoCurso.setTitulo("Master en Java y MongoDB");
        nuevoCurso.setDescripcion("Aprende a integrar Java con bases de datos NoSQL.");
        nuevoCurso.setPrecio(199.99);
        nuevoCurso.setRating(0.0);
        nuevoCurso.setInstructorId(instructorId);


        List<String> tags = new ArrayList<>();
        tags.add("Java"); tags.add("MongoDB"); tags.add("Backend");
        nuevoCurso.setTags(tags);

        modulos modulo1 = new modulos();
        modulo1.setModuloTitulo("Introducción a NoSQL");

        nuevoCurso.setModulo(modulo1);


        ObjectId idGenerado = controller.crearCurso(nuevoCurso);
        System.out.println("1. Curso creado con ID: " + idGenerado);

        if (idGenerado == null) return null;


        Optional<cursos> cursoEncontrado = controller.obtenerPorId(idGenerado);
        if (cursoEncontrado.isPresent()) {
            System.out.println("2. Curso encontrado: " + cursoEncontrado.get().getTitulo());
        } else {
            System.err.println("2. Error: No se encontrO el curso recien creado.");
        }


        if (cursoEncontrado.isPresent()) {
            cursos cursoAEditar = cursoEncontrado.get();
            cursoAEditar.setPrecio(150.00);
            cursoAEditar.setTitulo(cursoAEditar.getTitulo() + " (OFERTA)");

            boolean actualizado = controller.actualizarCurso(cursoAEditar);
            System.out.println("3. Curso actualizado: " + (actualizado ? "ÉXITO" : "FALLO"));


            controller.obtenerPorId(idGenerado).ifPresent(c ->
                    System.out.println("   -> Nuevo precio: " + c.getPrecio())
            );
        }


        System.out.println("4. Listando todos los cursos:");
        List<cursos> lista = controller.listarTodos();
        for (cursos c : lista) {
            System.out.println("   - " + c.getTitulo() + " | Precio: " + c.getPrecio());
        }

        System.out.println("--- [TEST] FIN CRUD CURSOS ---");
        return idGenerado;
    }


    private static ObjectId probarCicloInstructor(IInstructorController controller) {
        System.out.println("\n--- [TEST] INICIANDO CRUD DE INSTRUCTORES ---");


        Instructores instructor = new Instructores();
        instructor.setNombre("Juan Pérez");
        instructor.setCorreo("juan.perez@learnup.com");
        instructor.setBio("Experto en arquitectura de software.");
        instructor.setAniosExperiencia(10);

        Contacto contacto = new Contacto("555-1234", "linkedin.com/juan", "juanperez.dev");
        instructor.setContacto(contacto);

        ObjectId id = controller.registrarInstructor(instructor);
        System.out.println("1. Instructor registrado con ID: " + id);

        if (id == null) return null;


        controller.obtenerPorId(id).ifPresent(i ->
                System.out.println("2. Instructor encontrado: " + i.getNombre())
        );


        instructor.set_id(id);
        instructor.setAniosExperiencia(11);
        controller.actualizarInstructor(instructor);
        System.out.println("3. Instructor actualizado (Años exp: 11).");


        System.out.println("4. Total de instructores en DB: " + controller.listarTodos().size());


        return id;
    }


    private static void probarCicloEstudiante(IEstudianteController controller, ObjectId idCurso) {
        System.out.println("\n--- [TEST] INICIANDO CRUD DE ESTUDIANTES ---");


        estudiantes estudiante = new estudiantes();
        estudiante.setNombre("Maria González");
        estudiante.setCorreo("maria@gmail.com");


        configuraciones config = new configuraciones(true, true, "ES");
        estudiante.setConfiguraciones(config);


        if (idCurso != null) {
            cursosMatriculados matricula = new cursosMatriculados();
            matricula.setCursoId(idCurso);
            matricula.setEnrollmentDate(new Date());
            matricula.setProgreso(0.0);
            estudiante.setCursosMatriculados(matricula);
        }

        ObjectId id = controller.registrarEstudiante(estudiante);
        System.out.println("1. Estudiante registrado con ID: " + id);

        if (id == null) return;


        controller.obtenerPorId(id).ifPresent(e ->
                System.out.println("2. Estudiante: " + e.getNombre() + " | Modo Oscuro: " + e.getConfiguraciones().isModoOscuro())
        );


        estudiante.set_id(id);
        estudiante.setNombre("Maria G. (Editado)");
        controller.actualizarEstudiante(estudiante);
        System.out.println("3. Estudiante actualizado.");


        boolean eliminado = controller.eliminarEstudiante(id);
        System.out.println("4. Estudiante eliminado: " + eliminado);


        boolean existe = controller.obtenerPorId(id).isPresent();
        System.out.println("   -> ¿Sigue existiendo?: " + (existe ? "SI" : "NO"));
    }
}