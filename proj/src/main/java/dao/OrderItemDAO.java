package dao;
import java.util.List;
import model.OrderItem;

public interface OrderItemDAO {

	public List<OrderItem> getItemsFromPurchaseId(int purchId);
	
}
