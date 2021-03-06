package jasmin.carwash.jsw.controllers;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jasmin.carwash.jsw.models.centre.CentreDto;
import jasmin.carwash.jsw.models.centre.CentreNomDto;
import jasmin.carwash.jsw.services.centre.CentreService;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/centre")
public class CentreController{
    @Value("${centre.stream.delay}") Integer delay;
    @Autowired CentreService centreService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux< List<CentreDto> > streamAll(){
        return Flux.interval(Duration.ofSeconds(delay))
        .map(e->centreService.findAll()).distinct(); 
    }

    @GetMapping("/none-responsable")
    public List<CentreNomDto> findWithoutResponsable(){
        return centreService.findWithoutResponsable();
    }
    @GetMapping("/id/{id}")
    public CentreDto byId(@PathVariable("id") Integer id){
        return centreService.findById(id);
    }
    @GetMapping("/all")
    public List<CentreDto> findAll(){
        return centreService.findAll();
    }

    @GetMapping("/{label}")
    public CentreDto findByLabel(@PathVariable("label") String label){
        return centreService.findByLabel(label); 
    }

    @GetMapping("/match")
    public List<String> findLabels(@RequestParam String label){
        return centreService.findLabelHavingMatch(label); 
    }

    @PostMapping
    public void save(@RequestBody CentreDto centreDto){
        centreService.save(centreDto);
    }
    
    @PutMapping
    public void update(@RequestBody CentreDto centreDto){
        if( centreDto.getId() == null ) return;
        centreService.save( centreDto );
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Integer id){
        centreService.remove(id);
    }


}
