package com.amwang.biz.serverModel.entity;

import java.util.Date;

public class TSeqSumData {
    private Integer id;

    private String textNo;

    private String seq;

    private String big;

    private String small;

    private String single;

    private String doubles;

    private String createTime;
    
    private String value;

    public String getDoubles() {
		return doubles;
	}

	public void setDoubles(String doubles) {
		this.doubles = doubles;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextNo() {
        return textNo;
    }

    public void setTextNo(String textNo) {
        this.textNo = textNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}