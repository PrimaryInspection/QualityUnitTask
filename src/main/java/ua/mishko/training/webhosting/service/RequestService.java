package ua.mishko.training.webhosting.service;

import ua.mishko.training.webhosting.domain.Request;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public interface RequestService {

    List<Request> getRequestsList(Long limit);
    Map<Request, List<Request>> getQueriesAvailableForEachRequest(List<Request> requestList);
    Map<Long, String> getAverageResponseTime(List<Request> requestList);
    OptionalDouble calculateAverageForAllServicesAndQuestions(Map.Entry<Request, List<Request>> entry);
    OptionalDouble calculateAverageForAllServices(Map.Entry<Request, List<Request>> entry);
    OptionalDouble calculateAverageForAllQuestions(Map.Entry<Request, List<Request>> entry);
    OptionalDouble calculateAverageForAll(Map.Entry<Request, List<Request>> entry);
    List<Request> getAllRequest();
    void saveRequest(Request request);
}
