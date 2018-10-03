package be.thomasmore.travelmore.frontend;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(value = "locationController")
@ViewScoped
public class LocationController {

    private Location newLocation = new Location();

    @Inject
    private LocationService locationService;

    public List<Location> getLocations(){
        return this.locationService.findAllLocations();
    }

    public void submit(){
        this.locationService.insert(newLocation);
    }

}
