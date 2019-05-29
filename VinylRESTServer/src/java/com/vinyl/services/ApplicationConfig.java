package com.vinyl.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alans
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.vinyl.services.VinylAlbums.class);
        resources.add(com.vinyl.services.VinylUsers.class);
    }
    
}
