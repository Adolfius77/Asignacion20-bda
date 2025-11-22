package dao.impl;

import Exceptions.DaoException;
import Exceptions.EntityNotFoundException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import dao.ICursoDAO;
import model.cursos;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class cursoDAO implements ICursoDAO {

    private final MongoCollection<cursos> col;
    public cursoDAO(MongoCollection<cursos> col){
        this.col = col;
    }

    @Override
    public ObjectId crearCurso(cursos entidad) throws DaoException {
        try {
            if(entidad.get_id()== null)entidad.set_id(new ObjectId());
            Date ahora = new Date();
            entidad.setCreatedAt(ahora);
            entidad.setUpdatedAt(ahora);

            col.insertOne(entidad);
            return entidad.get_id();
        }catch (Exception e){
            throw new DaoException("error al crear un curso",e);
        }
    }

    @Override
    public Optional<cursos> encontrarPorId(ObjectId _id)throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id",_id)).first());
        }catch (MongoException e){
            throw new DaoException("error al consultar un curso",e);
        }
    }

    @Override
    public List<cursos> encontrarTodos() throws DaoException {
      try{
          return col.find().into(new java.util.ArrayList<>());
      }catch (MongoException e){
          throw new DaoException("error al consultar todos los cursos",e);
      }
    }

    @Override
    public boolean actualizar(cursos entidad) throws DaoException {
        try{
            entidad.setUpdatedAt(new Date());
            UpdateResult resultado = col.replaceOne(
                    Filters.eq("_id",entidad.get_id()),
                    entidad
            );
            return resultado.getModifiedCount() > 0;
        }catch (MongoException e){
            throw new DaoException("error al actualizar un curso",e);
        }
    }

    @Override
    public boolean eliminarPorId(ObjectId _id) throws DaoException, EntityNotFoundException {
       try{
           var resultado = col.deleteOne(Filters.eq("_id",_id));;
           if(resultado.getDeletedCount()== 0)
               throw new EntityNotFoundException("curso no existe: " + _id);
           return true;
       }catch (MongoException e){
           throw new DaoException("error al eliminar un curso",e);
       }
    }

    @Override
    public long borrarTodos() throws DaoException {
       try{
           return col.deleteMany(Filters.eq("_id")).getDeletedCount();
       }catch (MongoException e){
           throw new DaoException("error al borrar todos los cursos",e);
       }
    }

    @Override
    public Optional<cursos> encontrarPorTitulo(String titulo) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("titulo",titulo)).first());
            }catch (MongoException e){
            throw new DaoException("error al consultar un curso por titulo",e);
        }
    }
}
