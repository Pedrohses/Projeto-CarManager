package api.cotroller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Table;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jooq.DSLContext;

import api.dao.Dao;
import api.model.Carro;

@Path("carro")
public class MainController {
    @Inject
    Dao dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carro> getServers() {
        DSLContext dslCtx = dao.getDSLContext();
        Table table = Carro.class.getAnnotation(Table.class);
        return dslCtx.select().from(table.name()).fetch().into(Carro.class);
    }
}
