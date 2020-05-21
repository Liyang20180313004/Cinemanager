package xyz.changzhen.cinemanager.models;

import net.lzzy.sqllib.SqlRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import xyz.changzhen.cinemanager.constants.DbConstants;
import xyz.changzhen.cinemanager.utils.AppUtils;

/**
 * @author zhen
 */
public class CinemaFactory {

    private static final CinemaFactory ourInstance = new CinemaFactory();
    private static SqlRepository<Cinema> repository;

    private static CinemaFactory getInstance() {
        //        if (ourInstance == null) {
        //            synchronized (CinemaFactory.class) {
        //                if (ourInstance == null) {
        //                    ourInstance = new CinemaFactory();
        //                }
        //            }
        //        }
        return ourInstance;
    }

    private CinemaFactory() {
        repository = new SqlRepository<>(AppUtils.getContext(), Cinema.class, DbConstants.packager);
    }

    private List<Cinema> getAll() {
        return repository.get();
    }

    public Cinema getById(UUID id) {
        return repository.getById(id.toString());
    }

    public List<Cinema> search(String keyWord) {
        List<Cinema> cinemas = new ArrayList<>();
        List<Cinema> all = repository.get();
        for (Cinema c : all) {
            if (c.toString().contains(keyWord)) {
                cinemas.add(c);
            }
        }
        return cinemas;
    }

    private boolean isCinemaExists(Cinema cinema) throws InstantiationException, IllegalAccessException {
        List<Cinema> localCinemas = repository.getByKeyword(cinema.getLocation(), new String[]{Cinema.COL_LOCATION}, true);
        for (Cinema c : localCinemas) {
            if (c.getName().equals(cinema.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean addCinema(Cinema cinema) {
        try {
            if (isCinemaExists(cinema)) {
                repository.insert(cinema);
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean canCinemaDeleted(Cinema cinema) {
        // TODO: OrderFactory完成后再重写该方法， 判断影院是否已有订单
        return false;
    }

    public boolean removeCinema(Cinema cinema) {
        if (canCinemaDeleted(cinema)) {
            repository.delete(cinema);
            return true;
        }
        return false;
    }

}
