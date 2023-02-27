package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Helmets;

public interface HelmetsRepository extends JpaRepository<Helmets, Integer> {
}
