package lab5;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {

    @GET
    public List<Person> getPersons(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("age") Integer age,
                                   @QueryParam("phone") Integer phone,
                                   @QueryParam("gender") String gender) {
        return new PostgreSQLDAO().getPersons(name, surname, age, phone, gender);
    }

    @POST
    public Integer addPerson(Person person){
        return new PostgreSQLDAO().addPerson(person.getName(), person.getSurname(),
                person.getAge(), person.getPhone(), person.getGender());
    }

    @PUT
    public String updatePerson(Integer id, Person person){
        return new PostgreSQLDAO().updatePerson(id, person.getName(), person.getSurname(),
                person.getAge(), person.getPhone(), person.getGender());
    }

    @DELETE
    public String deletePerson(Integer id){
        return new PostgreSQLDAO().deletePerson(id);
    }
}