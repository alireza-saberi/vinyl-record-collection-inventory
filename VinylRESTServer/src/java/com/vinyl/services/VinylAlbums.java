package com.vinyl.services;

import com.vinyl.DAO.AlbumDAO;
import com.vinyl.model.Album;
import com.vinyl.model.UserAlbum;
import com.vinyl.model.Users;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alans
 */
@Path("album")
public class VinylAlbums {

    @POST
    @Path("/addalbum")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void addAlbum(UserAlbum userAlbum) {
        Users user = userAlbum.getUser();
        Album album = userAlbum.getAlbum();
        AlbumDAO db = new AlbumDAO();
        db.addAlbum(user, album);
    }

    @POST
    @Path("/readalbums")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Album> readAlbums(Users user) {
        AlbumDAO db = new AlbumDAO();
        return db.readAlbums(user);
    }

    @PUT
    @Path("/updateuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void updateAlbum(UserAlbum userAlbum) {
        Users user = userAlbum.getUser();
        Album album = userAlbum.getAlbum();
        AlbumDAO db = new AlbumDAO();
        db.updateAlbum(user, album);
    }

    @DELETE
    @Path("/delalbum")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void deleteAlbum(UserAlbum userAlbum) {
        Users user = userAlbum.getUser();
        Album album = userAlbum.getAlbum();
        AlbumDAO db = new AlbumDAO();
        db.deleteAlbum(user, album);
    }

    @DELETE
    @Path("/delalbums")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void deleteAllAlbum(Users user) {
        AlbumDAO db = new AlbumDAO();
        db.deleteAllAlbum(user);
    }
}
