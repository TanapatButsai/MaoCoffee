package ku.cs.MaoCoffee.service;

import ku.cs.MaoCoffee.Status;
import ku.cs.MaoCoffee.entity.Menu;
import ku.cs.MaoCoffee.entity.OrderItem;
import ku.cs.MaoCoffee.entity.OrderItemKey;
import ku.cs.MaoCoffee.entity.PurchaseOrder;
import ku.cs.MaoCoffee.model.AddCartRequest;
import ku.cs.MaoCoffee.repository.MenuRepository;
import ku.cs.MaoCoffee.repository.OrderItemRepository;
import ku.cs.MaoCoffee.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class OrderService {


    @Autowired
    private PurchaseOrderRepository orderRepository;


    @Autowired
    private OrderItemRepository itemRepository;


    @Autowired
    private MenuRepository menuRepository;


    private UUID currentOrderId;


    public void createNewOrder() {
        PurchaseOrder newOrder = new PurchaseOrder();
        newOrder.setStatus(Status.ORDER);
        PurchaseOrder record = orderRepository.save(newOrder);
        currentOrderId = record.getId();
    }


    public void order(UUID menuId, AddCartRequest request) {
        if (currentOrderId == null)
            createNewOrder();


        PurchaseOrder currentOrder =
                orderRepository.findById(currentOrderId).get();
        Menu menu = menuRepository.findById(menuId).get();


        OrderItem item = new OrderItem();
        item.setId(new OrderItemKey(currentOrderId, menuId));
        item.setPurchaseOrder(currentOrder);
        item.setMenu(menu);
        item.setQuantity(request.getQuantity());
        itemRepository.save(item);
    }
}

