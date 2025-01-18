package mb.project.sspn.Finances.Repository;

import mb.project.sspn.Finances.Model.Finance;
import mb.project.sspn.Finances.Model.Finance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinanceRepository {

    private final JdbcTemplate jdbc;

    public FinanceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addNew(Finance finance) {
        String sql = "INSERT INTO Finances (date, transaction, description,value) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, finance.getDate(), finance.getTransaction(), finance.getDescription(), finance.getValue());
    }

    public List<Finance> getFinances() {
        String sql = "SELECT * FROM Finances";
        return jdbc.query(sql, (rs, rowNum) ->
                new Finance(
                        rs.getInt("financeId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("transaction"),
                        rs.getString("description"),
                        rs.getInt("value")
                )
        );
    }

    public Boolean validade(Finance finance) {
        if (finance.getTransaction() == null || (!finance.getTransaction().equalsIgnoreCase("entrada") && !finance.getTransaction().equalsIgnoreCase("saida")))
            throw new IllegalStateException("O tipo deve ser 'entrada' ou 'saida'.");
        if (finance.getValue() <= 0)
            throw new IllegalStateException("O valor deve ser maior que zero.");
        if (finance.getDescription() == null || finance.getDescription().isEmpty())
            throw new IllegalStateException("Por favor insira uma descrição valida do produto");
        return true;
    }
}
