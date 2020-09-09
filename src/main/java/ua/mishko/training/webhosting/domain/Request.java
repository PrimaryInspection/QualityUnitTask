package ua.mishko.training.webhosting.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request implements Serializable,Comparable<Request> {

    private static final long serialVersionUID = -8649221221971982229L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", nullable = false)
    private Service serviceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id",nullable = false)
    private Question questionId;

    // P/N
    @Column(name = "response_type", nullable = false)
    private String responseType;

    // C/D
    @Column(name = "query_type", nullable = false)
    private String queryType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "response_wait_time")
    private Integer responseWaitTime;

    public Request() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getResponseWaitTime() {
        return responseWaitTime;
    }

    public void setResponseWaitTime(Integer responseWaitTime) {
        this.responseWaitTime = responseWaitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return getId().equals(request.getId()) &&
                getServiceId().equals(request.getServiceId()) &&
                getQuestionId().equals(request.getQuestionId()) &&
                getResponseType().equals(request.getResponseType()) &&
                getQueryType().equals(request.getQueryType()) &&
                getDate().equals(request.getDate()) &&
                getStartDate().equals(request.getStartDate()) &&
                getEndDate().equals(request.getEndDate()) &&
                getResponseWaitTime().equals(request.getResponseWaitTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getServiceId(), getQuestionId(), getResponseType(), getQueryType(), getDate(), getStartDate(), getEndDate(), getResponseWaitTime());
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", questionId=" + questionId +
                ", responseType='" + responseType + '\'' +
                ", queryType='" + queryType + '\'' +
                ", date='" + date + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", responseWaitTime=" + responseWaitTime +
                '}';
    }

    @Override
    public int compareTo(Request o) {
        return this.getId().compareTo(o.getId());
    }
}