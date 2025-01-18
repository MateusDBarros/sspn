package mb.project.sspn.Finances.Service;

import mb.project.sspn.Finances.Model.Finance;
import mb.project.sspn.Finances.Repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository repository;


    public FinanceService(FinanceRepository repository) {
        this.repository = repository;
    }

    public void addNew(Finance finance) {
        if (repository.validade(finance))
            repository.addNew(finance);
    }

    public List<Finance> getFinance() {
        return repository.getFinances();
    }
}
