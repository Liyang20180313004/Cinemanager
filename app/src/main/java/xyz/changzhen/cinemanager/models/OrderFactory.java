package xyz.changzhen.cinemanager.models;

import net.lzzy.sqllib.DbPackager;
import net.lzzy.sqllib.SqlRepository;

import java.util.List;
import java.util.UUID;

import xyz.changzhen.cinemanager.constants.DbConstants;
import xyz.changzhen.cinemanager.utils.AppUtils;

/**
 * @author zhen
 */
public class OrderFactory {

    private static final OrderFactory ourInstance = new OrderFactory();
    private SqlRepository<Order> mRepository;

    public static OrderFactory getInstance() {
        return ourInstance;
    }

    private OrderFactory() {
        mRepository = new SqlRepository<>(AppUtils.getContext(), Order.class, DbConstants.packager);
    }

    public List<Order> getAll() {
        return mRepository.get();
    }

    public Order getById(UUID id) {
        return mRepository.getById(id.toString());
    }

    private boolean isOrderExists(Order order) {
        if (mRepository.getById(order.getId().toString()) == null) {
            return true;
        }
        return false;
    }

    public boolean addOrder(Order order) {
        if (!isOrderExists(order)) {
            mRepository.insert(order);
            return true;
        }
        return false;
    }

    private boolean canOrderDelete(Order order) {
        return false;
    }

}
