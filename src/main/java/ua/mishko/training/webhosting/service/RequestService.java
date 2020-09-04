package ua.mishko.training.webhosting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mishko.training.webhosting.domain.Request;
import ua.mishko.training.webhosting.repository.RequestRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    /**
     * Get all requests from database using limit.
     *
     * @param limit - Limit of The number of elements that the user sees on the page,
     *                if more than is specified  in the database,
     *                then the limit = the size of the collection
     *
     * */
    public List<Request> getRequestsList(Long limit) {
        if (limit > requestRepository.findAllRequest().size()) {
            int newLimit = requestRepository.findAllRequest().size();
            return requestRepository.findAllRequest().stream().limit(newLimit).collect(Collectors.toList());
        } else {
            return requestRepository.findAllRequest().stream().limit(limit).collect(Collectors.toList());
        }
    }

    /**
     * Get all requests(C-Type), which are higher on the list than requests(D-Type)
     * @param requestList - list of all Requests from database.
     * @return Map<Request,List<Request>> , where 'Request' is the request(D-Type),
     * to which the collection of requests(C-Type) matches
     * */
    public Map<Request, List<Request>> getQueriesAvailableForEachRequest(List<Request> requestList) {
        Map<Request, List<Request>> requestAndAvailableQueriesMap = new HashMap<>();
        for (Request request : requestList) {
            if (request.getQueryType().equals("D")) {
                List<Request> requests = requestList.stream()
                        .filter(i -> i.getId() < request.getId())
                        .filter(i -> i.getQueryType()
                                .startsWith("C"))
                        .collect(Collectors.toList());

                requestAndAvailableQueriesMap.put(request, requests);
            }
        }
        return requestAndAvailableQueriesMap;
    }

    /**
     * Gets the average response time for requests that match criteria
     * @param requestList - list of all Requests from database.
     * @return Map<Long, String>, where Long is request's(D-Type) id,
     * and String this is the converted(from OptionalDouble) average of response time
     * */
    public Map<Long, String> getAverageResponseTime(List<Request> requestList) {
        Map<Long, String> averageValues = new HashMap<>();
        Map<Request, List<Request>> queries = getQueriesAvailableForEachRequest(requestList);
        OptionalDouble average;
        String convertedAverage;
        for (Map.Entry<Request, List<Request>> entry : queries.entrySet()) {
            if (entry.getKey().getServiceId().getName().equals("*") && entry.getKey().getQuestionId().getName().equals("*")) {
                average = calculateAverageForAllServicesAndQuestions(entry);
            } else if (entry.getKey().getServiceId().getName().equals("*")) {
                average = calculateAverageForAllServices(entry);
            } else if (entry.getKey().getQuestionId().getName().equals("*")) {
                average = calculateAverageForAllQuestions(entry);
            } else {
                average = calculateAverageForAll(entry);
            }
            if (average.isPresent()) {
                convertedAverage = String.valueOf((int) average.getAsDouble());
            } else
                convertedAverage = "--";
            Long key = entry.getKey().getId();
            averageValues.put(key, convertedAverage);
        }
        return averageValues;
    }

    /**
     * Calculates the average value for records for which service.id and question.id = '*'
     * */
    public OptionalDouble calculateAverageForAllServicesAndQuestions(Map.Entry<Request, List<Request>> entry) {
        return entry.getValue().stream()
                .filter(i -> i.getResponseType().equals(entry.getKey().getResponseType()))
                .filter(i -> i.getDate().isAfter(entry.getKey().getStartDate()))
                .filter(i -> i.getDate().isBefore(entry.getKey().getEndDate()))
                .mapToInt(Request::getResponseWaitTime).average();
    }

    /**
     * Calculates the average value for records for which service.id = '*'
     * */
    public OptionalDouble calculateAverageForAllServices(Map.Entry<Request, List<Request>> entry) {
        return entry.getValue().stream()
                .filter(i -> i.getQuestionId().equals(entry.getKey().getQuestionId()))
                .filter(i -> i.getResponseType().equals(entry.getKey().getResponseType()))
                .filter(i -> i.getDate().isAfter(entry.getKey().getStartDate()))
                .filter(i -> i.getDate().isBefore(entry.getKey().getEndDate()))
                .mapToInt(Request::getResponseWaitTime).average();
    }

    /**
     * Calculates the average value for records for which question.id = '*'
     * */
    public OptionalDouble calculateAverageForAllQuestions(Map.Entry<Request, List<Request>> entry) {
        return entry.getValue().stream()
                .filter(i -> i.getServiceId().equals(entry.getKey().getServiceId()))
                .filter(i -> i.getResponseType().equals(entry.getKey().getResponseType()))
                .filter(i -> i.getDate().isAfter(entry.getKey().getStartDate()))
                .filter(i -> i.getDate().isBefore(entry.getKey().getEndDate()))
                .mapToInt(Request::getResponseWaitTime).average();
    }

    /**
     * Calculates the average value for records for which the service and question are specified exactly
     * */
    public OptionalDouble calculateAverageForAll(Map.Entry<Request, List<Request>> entry) {
        return entry.getValue().stream()
                .filter(i -> i.getServiceId().equals(entry.getKey().getServiceId()))
                .filter(i -> i.getQuestionId().equals(entry.getKey().getQuestionId()))
                .filter(i -> i.getResponseType().equals(entry.getKey().getResponseType()))
                .filter(i -> i.getDate().isAfter(entry.getKey().getStartDate()))
                .filter(i -> i.getDate().isBefore(entry.getKey().getEndDate()))
                .mapToInt(Request::getResponseWaitTime).average();
    }
    /**
     * Get all requests(for title on page)
     * */
   public List<Request> getAllRequest(){
        return requestRepository.findAll();
    }
}
