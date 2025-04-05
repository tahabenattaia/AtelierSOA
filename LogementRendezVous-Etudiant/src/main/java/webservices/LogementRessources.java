package webservices;

import metiers.LogementBusiness;
import entities.Logement;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/logement")
public class LogementRessources {
    LogementBusiness help = new LogementBusiness();

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.
                status(200).
                entity(help.getLogements()).
                build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLogement(Logement logement) {
        boolean added = help.addLogement(logement);

        if (added) {
            return Response
                    .status(Status.CREATED)
                    .entity(logement)
                    .build();
        } else {
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity("Failed to create logement")
                    .build();
        }
    }
}

