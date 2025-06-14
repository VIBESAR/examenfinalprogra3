package com.quarkus.resource;

import com.quarkus.dto.PersonDto;
import com.quarkus.model.Address;
import com.quarkus.service.AddressService;
import com.quarkus.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService service;

    @Inject
    AddressService addressService;

    @GET
    public List<PersonDto> listAll() {
        return service.listAll();
    }

    @POST
    public void create(PersonDto dto) {
        service.create(dto);
    }

    @GET
    @Path("/{id}/addresses")
    public List<Address> getAddresses(@PathParam("id") Long id) {
        return addressService.findByPersonId(id);
    }
}
