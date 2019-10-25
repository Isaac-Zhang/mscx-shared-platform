package com.sxzhongf.karaf.rest.provider;

import com.sxzhongf.karaf.rest.api.Booking;
import com.sxzhongf.karaf.rest.api.BookingService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/25
 */
@Path("/")
public class BookingServiceRest implements BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Booking> list() {
        return bookings.values();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Booking get(@PathParam("id") Long id) {
        return bookings.get(id);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Booking booking) {
        bookings.remove(booking.getId());
        bookings.put(booking.getId(), booking);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        bookings.remove(id);
    }
}
