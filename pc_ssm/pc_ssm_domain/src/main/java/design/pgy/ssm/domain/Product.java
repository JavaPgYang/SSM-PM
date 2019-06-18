package design.pgy.ssm.domain;

import design.pgy.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product {

    private String id;
    private String productNum;
    private String productName;
    private String cityName;

//    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date departureTime;     // 出发时间
    private String departureTimeStr;    // 出发时间字符串表示形式

    private Double productPrice;
    private String productDesc;

    private Integer productStatus;      // 产品目前状态
    private String productStatusStr;    // 产品目前状态字符串表示形式

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.date2String(departureTime, "yyyy-MM-dd HH:mm");
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if (productStatus == 0) {
            productStatusStr = "关闭";
        } else if (productStatus == 1) {
            productStatusStr = "开启";
        }
        return productStatusStr;
    }
}
