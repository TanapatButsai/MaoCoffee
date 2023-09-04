package ku.cs.MaoCoffee.repository;

import ku.cs.MaoCoffee.entity.OrderItem;
import ku.cs.MaoCoffee.entity.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}

