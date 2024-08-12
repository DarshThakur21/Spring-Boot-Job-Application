package com.company.first_jobappproject.reviews;


import java.util.List;


public interface ReviewService {
    List<Review> getallreviews(Long companyId);

    boolean addreview(Long companyId, Review review);
    Review getreview(Long companyId, Long reviewId);
    boolean  updatereview(Long CompanyId,Long reviewId,Review review);
    boolean deletereview(Long CompanyId,Long reviewId);
}
