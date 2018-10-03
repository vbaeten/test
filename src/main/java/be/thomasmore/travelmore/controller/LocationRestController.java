package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("locations")
public class LocationRestController {
    @Inject
    private LocationService locationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocations() {
        List<Location> locations = locationService.findAllLocations();

        return Response.status(OK).entity(locations).build();
    }

    @GET
    @Path("{locationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation(@PathParam("locationId") int locationId) {
        Location location = locationService.findLocationById(locationId);

        return Response.status(OK).entity(location).build();
    }

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation(@QueryParam("code") String code) {
        Location location = locationService.findLocationByCode(code);

        return Response.status(OK).entity(location).build();
    }

    @PUT
    @Path("{locationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCode(@PathParam("locationId") int id, @QueryParam("newName") String newName) {
        locationService.updateName(id, newName);

        return Response.status(OK).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Location location) {
        locationService.insert(location);

        return Response.status(OK).build();
    }
}
