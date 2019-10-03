package com.revature.beans;

import java.util.Date;

public class Request {
	private int reqId;
	private String title;
	private String summary;
	private int reqEmp;
	private float amount;
	Date reqDate;
	int status;
	Date statusDate;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int reqId, String title, String summary, int reqEmp, float amount, Date reqDate, int status,
			Date statusDate) {
		super();
		this.reqId = reqId;
		this.title = title;
		this.summary = summary;
		this.reqEmp = reqEmp;
		this.amount = amount;
		this.reqDate = reqDate;
		this.status = status;
		this.statusDate = statusDate;
	}
	
	public Request(String title, String summary, int reqEmp, float amount, Date reqDate, int status,
			Date statusDate) {
		super();
		this.title = title;
		this.summary = summary;
		this.reqEmp = reqEmp;
		this.amount = amount;
		this.reqDate = reqDate;
		this.status = status;
		this.statusDate = statusDate;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getReqEmp() {
		return reqEmp;
	}

	public void setReqEmp(int reqEmp) {
		this.reqEmp = reqEmp;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((reqDate == null) ? 0 : reqDate.hashCode());
		result = prime * result + reqEmp;
		result = prime * result + reqId;
		result = prime * result + status;
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (reqDate == null) {
			if (other.reqDate != null)
				return false;
		} else if (!reqDate.equals(other.reqDate))
			return false;
		if (reqEmp != other.reqEmp)
			return false;
		if (reqId != other.reqId)
			return false;
		if (status != other.status)
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [reqId=" + reqId + ", title=" + title + ", summary=" + summary + ", reqEmp=" + reqEmp
				+ ", amount=" + amount + ", reqDate=" + reqDate + ", status=" + status + ", statusDate=" + statusDate
				+ "]";
	}

}
