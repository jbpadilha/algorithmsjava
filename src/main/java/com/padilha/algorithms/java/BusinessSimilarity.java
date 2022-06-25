package com.padilha.algorithms.java;

import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class BusinessSimilarity {

    static class PositiveReview {
        Integer userId;
        Integer businessId;

        PositiveReview(Integer userId, Integer businessId) {
            this.userId = userId;
            this.businessId = businessId;
        }

        public Integer getUserId() {
            return userId;
        }

        public Integer getBusinessId() {
            return businessId;
        }
    }
    /*
    Sample Input
        {
            "businessOfInterestId": 10,
            "positiveReviews": [
                PositiveReview(
                    "userId": 1,
                    "businessId": 10
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 10
                ),
                PositiveReview(
                    "userId": 1,
                    "businessId": 11
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 11
                ),
                PositiveReview(
                    "userId": 1,
                    "businessId": 12
                ),
                PositiveReview(
                    "userId": 2,
                    "businessId": 12
                ),
                PositiveReview(
                    "userId": 3,
                    "businessId": 12
                )
            ]
        }
    Sample Output
        11
    Business Similarity Score against business 10:
        11: 2 / (2 + 2 - 2) = 1.0
        12: 2 / (2 + 3 - 2) = 0.667
    */
    public static Integer findMostSimilarBusiness(
            Integer businessOfInterestId,
            List<PositiveReview> positiveReviews
    ) {
        // Todo: Complete Me
        Integer similarity = 0;
        List<PositiveReview> nUsersBusiness = positiveReviews.stream()
                .filter(s -> s.getBusinessId().equals(businessOfInterestId)).collect(Collectors.toList());

        Map<Integer, Integer> businessUsersMap = new HashMap<>();
        Map<Integer, Integer> businessSimilarUsersMap = new HashMap<>();
        for (int i= 0; i < positiveReviews.size(); i++) {
            PositiveReview positiveReview = positiveReviews.get(i);
            if (!positiveReview.getBusinessId().equals(businessOfInterestId)) {
                if (businessUsersMap.get(positiveReview.getBusinessId()) != null) {
                    businessUsersMap.put(positiveReview.getBusinessId(), businessUsersMap.get(positiveReview.getBusinessId()) + 1);
                } else {
                    businessUsersMap.put(positiveReview.getBusinessId(), 1);
                }
                List similar = nUsersBusiness.stream().filter(s -> s.getUserId().equals(positiveReview.getUserId())).collect(Collectors.toList());
                if(similar != null && similar.size() > 0) {
                    if (businessSimilarUsersMap.get(positiveReview.getBusinessId()) != null) {
                        businessSimilarUsersMap.put(positiveReview.getBusinessId(), businessSimilarUsersMap.get(positiveReview.getBusinessId()) + 1);
                    } else {
                        businessSimilarUsersMap.put(positiveReview.getBusinessId(), 1);
                    }
                }
            }
        }
        Integer highScoreSimilarity = 0;
        for (Map.Entry<Integer, Integer> entry : businessUsersMap.entrySet()){
            Integer currSimilarity = nUsersBusiness.size() / (nUsersBusiness.size() + businessUsersMap.get(entry.getKey()) - businessSimilarUsersMap.get(entry.getKey()));
            if (currSimilarity > highScoreSimilarity) {
                highScoreSimilarity = currSimilarity;
                similarity = entry.getKey();
            }
        }
        return similarity;
    }

    public static void main(String[] args) {
        List<PositiveReview> positiveReviews = new ArrayList<>(
                Arrays.asList(
                        new PositiveReview(1, 10),
                        new PositiveReview(2, 10),
                        new PositiveReview(1, 11),
                        new PositiveReview(2, 11),
                        new PositiveReview(1, 12),
                        new PositiveReview(2, 12),
                        new PositiveReview(3, 12)
                )
        );
        if (findMostSimilarBusiness(10, positiveReviews).equals(11)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
