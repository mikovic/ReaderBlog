package readerblog.mates.readerblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import readerblog.mates.readerblog.entities.Category;

/**
 * @author @ivanleschinsky
 * @author unknown
 */
//TODO fix update method
@Repository
@EnableTransactionManagement
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    Category removeById(Long id);

    Category removeByName(String name);

    @Query(value = "UPDATE categories set name = :newName where name = :oldName", nativeQuery = true)
    Integer update(String oldName, String newName);
}
