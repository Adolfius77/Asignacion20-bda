package dao.impl;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import dao.IInstructorDAO;
import model.Instructores;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class instructoresDAO implements IInstructorDAO {

    private final MongoCollection<Instructores> col;
    public instructoresDAO(MongoCollection<Instructores> col){
        this.col = col;
    }

    @Override
    public ObjectId crearInstructor(Instructores entidad) throws DaoException {
        try{
            if(entidad.get_id() == null) entidad.set_id(new ObjectId());
            col.insertOne(entidad);
            return entidad.get_id();
        }catch (MongoException e){
            throw new DaoException("error al crear un instructor",e);
        }
    }

    @Override
    public Optional<Instructores> encontrarPorId(ObjectId _id) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id",_id)).first());

        }catch (MongoException e){
            throw new DaoException("error al consultar un instructor",e);
        }
    }

    @Override
    public List<Instructores> encontrarAtodos() throws DaoException {
        try{
            return col.find().into(new ArrayList<>());

        }catch (MongoException e){
            throw new DaoException("error al consultar a todos los instructores",e);
        }
    }

    @Override
    public Boolean actualizar(Instructores entidad) throws DaoException {
        try{
            UpdateResult resultado = col.replaceOne(
                    Filters.eq("_id",entidad.get_id()),
                    entidad
            );
            return resultado.getModifiedCount() > 0;
        }catch (MongoException e){
            throw new DaoException("error al actualizar un instructor",e);
        }
    }

    @Override
    public boolean eliminarPorId(ObjectId _id) throws DaoException, EntityNotFoundException {
        try{
            var resultado = col.deleteOne(Filters.eq("_id",_id));
            if(resultado.getDeletedCount()==0)
                throw new EntityNotFoundException("instructor no existe: " + _id);
            return true;
        }catch (MongoException e){
            throw new DaoException("error al eliminar un instructor",e);
        }
    }

    @Override
    public long borrarTodos() throws DaoException {
        try{
            return col.deleteMany(Filters.eq("_id")).getDeletedCount();
        }catch (MongoException e){
            throw new DaoException("error al borrar todos los instructores",e);
        }
    }

    @Override
    public Optional<Instructores> encontrarPorNombre(String nombre) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("nombre",nombre)).first());
        }catch (MongoException e){
            throw new DaoException("error al consultar un instructor por nombre",e);
        }
    }
}
