package ku.cs.MaoCoffee.repository;

import ku.cs.MaoCoffee.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {
}

