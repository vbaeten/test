package be.thomasmore.travelmore.frontend;

import be.thomasmore.travelmore.domain.Location;
import be.thomasmore.travelmore.service.LocationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "locationController")
@ViewScoped
public class LocationFrontendController {

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
