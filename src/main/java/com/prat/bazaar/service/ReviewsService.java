package com.prat.bazaar.service;

import com.prat.bazaar.model.Reviews;

import java.util.List;

public interface ReviewsService {

    List<Reviews> createReviews(List<Reviews> reviews);

    List<Reviews> getReviewsByUserId(String userId);
}
