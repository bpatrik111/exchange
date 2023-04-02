package com.bpatrik.exchange.exchange.models;

public class Convert {

    private Integer convert_id;
    private String from_;
    private String to_;
    private Integer rate;

    public Convert(Integer convert_id, String from_, String to_, Integer rate) {
        this.convert_id = convert_id;
        this.from_ = from_;
        this.to_ = to_;
        this.rate = rate;
    }

    public Integer getConvert_id() {
        return convert_id;
    }

    public void setConvert_id(Integer convert_id) {
        this.convert_id = convert_id;
    }

    public String getFrom_() {
        return from_;
    }

    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    public String getTo_() {
        return to_;
    }

    public void setTo_(String to_) {
        this.to_ = to_;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
