package xyz.changzhen.cinemanager.models;

import net.lzzy.sqllib.Column;
import net.lzzy.sqllib.Sqlitable;
import net.lzzy.sqllib.Table;

import java.util.UUID;

/**
 * @author zhen
 */
@Table(name = "Orders")
public class Order extends BaseEntity implements Sqlitable {
    private String movie;
    private float price;
    private String movieTime;
    @Column(type = Column.DbType.STRING, name = "cinema")
    private UUID cinemaId;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public UUID getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(UUID cinemaId) {
        this.cinemaId = cinemaId;
    }


    /**
     * 在app版本升级的时候，该类所映射的表架构是否发生变化
     * @return 发生变化则返回true，否则返回false
     */
    @Override
    public boolean needUpdate() {
        return false;
    }
}
