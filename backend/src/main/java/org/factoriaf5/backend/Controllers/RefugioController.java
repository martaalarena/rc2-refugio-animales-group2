package backend.src.main.java.org.factoriaf5.backend.Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RefugioController {

    private RefugioRepository repository;

    public RefugioController(@Autowired RefugioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/refugio")
    public List<RefugioResponse> showRefugio() {
        List<RefugioResponse> refugioResponse = new ArrayList<RefugioResponse>();
        List<Refugio> refugioInDataBaseRefugio = repository.findAll();
        for (Refugio refugio : refugioInDataBaseRefugio) {
            refugioResponse.add(new RefugioResponse(
                refugio.getId(),
                refugio.getTitle(),
                refugio.getDescription(),
                refugio.getContact(),
                refugio.getImageUrl()));
        }
        return refugioResponse;
    }
