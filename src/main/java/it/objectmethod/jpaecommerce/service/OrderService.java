package it.objectmethod.jpaecommerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.jpaecommerce.entity.Cart;
import it.objectmethod.jpaecommerce.entity.CartDetail;
import it.objectmethod.jpaecommerce.entity.Login;
import it.objectmethod.jpaecommerce.entity.Order;
import it.objectmethod.jpaecommerce.entity.OrderRow;
import it.objectmethod.jpaecommerce.repo.CartRepo;
import it.objectmethod.jpaecommerce.repo.LoginRepo;
import it.objectmethod.jpaecommerce.repo.OrderRepo;
import it.objectmethod.jpaecommerce.repo.OrderRowRepo;
import it.objectmethod.jpaecommerce.service.dto.OrderDTO;
import it.objectmethod.jpaecommerce.service.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private OrderMapper mapper;

	@Autowired
	private OrderRowRepo orderRowRepo;

	@Autowired
	private LoginRepo logRepo;

	@Autowired
	private CartRepo cartRepo;

	public List<OrderDTO> getOrderByUserId(Long userId) {
		List<OrderDTO> orderList = mapper.toDto(orderRepo.findByUserId(userId));
		return orderList;
	}

	public void insertOrder(String numOrder, Long userId) {
		LocalDate date = LocalDate.now();
		Optional<Login> user = logRepo.findById(userId);
		Order order = new Order();
		order.setNumOrder(numOrder);
		order.setUser(user.get());
		order.setDate(date);
		orderRepo.save(order);

		insertOrderRow(userId, order);
	}

	private void insertOrderRow(Long userId, Order order) {
		Cart cart = cartRepo.findByUserIdId(userId);
		List<CartDetail> cartList = cart.getCartList();

		for (CartDetail element : cartList) {
			OrderRow orderRow = new OrderRow();
			orderRow.setArticle(element.getArticleId());
			orderRow.setQuantity(element.getQuantita());
			orderRow.setOrderId(order.getId());
			orderRowRepo.save(orderRow);
		}
	}

}
