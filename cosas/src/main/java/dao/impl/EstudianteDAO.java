package dao.impl;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import dao.IEstudianteDAO;
import model.estudiantes;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

public class EstudianteDAO implements IEstudianteDAO {
    private final MongoCollection<estudiantes> col;
    public EstudianteDAO(MongoCollection<estudiantes> col){
        this.col = col;
    }

    @Override
    public ObjectId crearEstudiante(estudiantes entidad) throws DaoException {
        try {
            if(entidad.getId()== null)entidad.setId(new ObjectId());
            col.insertOne(entidad);
            return entidad.getId();
        }catch (MongoException e){
            throw new DaoException("error al crear un estudiantes",e);

        }
    }

    @Override
    public Optional<estudiantes> econtrarPorId(ObjectId _id) throws DaoException {
        try {
            return Optional.ofNullable(col.find(Filters.eq("_id", _id)).first());
        }catch (MongoException e){
            throw new DaoException("error al consultar un estudiante",e);

        }
    }

    @Override
    public List<estudiantes> encontrarTodos() throws DaoException {
        try{
            return col.find().into(new ArrayList<>());
        }catch (MongoException e){
            throw new DaoException("error al consultar todos los estudiantes",e);
        }
    }

    @Override
    public boolean actualizar(estudiantes entidad) throws DaoException {
       try{
           UpdateResult resultado = col.replaceOne(
                   Filters.eq("_id",entidad.getId()),
                   entidad
           );
           return resultado.getModifiedCount() > 0;
       }catch (MongoException e){
           throw new DaoException("error al actualizar un estudiante",e);
       }
    }

    @Override
    public boolean eliminarPorId(ObjectId _id) throws DaoException, EntityNotFoundException {
        try{
            var resultado = col.deleteOne(Filters.eq("_id",_id));
            if(resultado.getDeletedCount()== 0)
                throw new EntityNotFoundException("estudiante no existe: " + _id);
            return true;
        }catch (MongoException e){
            throw new DaoException("error al eliminar un estudiante",e);

        }
    }

    @Override
    public long borrarTodos() throws DaoException {
        try{
            return  col.deleteMany(Filters.eq("_id")).getDeletedCount();

        }catch (MongoException e){
            throw new DaoException("error al borrar todos los estudiantes",e);

        }
    }

    @Override
    public Optional<estudiantes> encontrarPorNombre(String nombre) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("nombre",nombre)).first());
        }catch (MongoException e){
            throw new DaoException("error al consultar un estudiante por nombre",e);
        }
    }
}
