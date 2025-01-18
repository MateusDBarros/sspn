package mb.project.sspn.Finances.Controller;

import mb.project.sspn.Finances.Model.Finance;
import mb.project.sspn.Finances.Service.FinanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/finances")
public class FinanceController {

    private final FinanceService service;

    public FinanceController(FinanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addNew(@RequestBody Finance finance) {
        service.addNew(finance);

        return ResponseEntity.status(HttpStatus.CREATED).body("New finance added sucessfully");
    }

    @GetMapping
    public ResponseEntity<List<Finance>> getFinances() {
        List<Finance> finances = service.getFinance();
        return ResponseEntity.status(HttpStatus.OK).body(finances);
    }
}
