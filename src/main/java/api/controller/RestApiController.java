package api.controller;

import api.entity.Bin;
import api.repository.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestApiController {

    private final BinRepository binRepository;


    @Autowired
    public RestApiController(BinRepository binRepository) {
        this.binRepository = binRepository;
    }


    @RequestMapping(value = "/bins_for_city/{city}", method = RequestMethod.GET)
    public List<Bin> getBinListForCity(@PathVariable String city) {
        return binRepository.findAllByCity(city);
    }

    @RequestMapping(value = "/bin_info/{latitude}/{longitude}", method = RequestMethod.GET)
    public Bin getBinInfo(@PathVariable Long latitude, @PathVariable Long longitude) {
        return binRepository.findBinByLatitudeAndLongitude(latitude, longitude);

    }


}
