package com.company.first_jobappproject.reviews.Impl;


import com.company.first_jobappproject.Company.Company;
import com.company.first_jobappproject.Company.CompanyService;
import com.company.first_jobappproject.reviews.Review;
import com.company.first_jobappproject.reviews.ReviewRepo;
import com.company.first_jobappproject.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
        private final ReviewRepo reviewRepo;
        private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepo reviewRepo,CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService=companyService;
    }

    @Override
    public List<Review> getallreviews(Long companyId) {
        List<Review> reviews=reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addreview(Long companyId, Review review) {
        Company company=companyService.findByid(companyId);
        if(company!=null){
            review.setCompany(company);
             reviewRepo.save(review);
             return true;
        }
        return false;

    }

    @Override
    public Review getreview(Long companyId, Long reviewId) {
        List<Review> reviews= reviewRepo.findByCompanyId(companyId);
//        Company company=companyService.findByid(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updatereview(Long companyId, Long reviewId, Review updatedreview) {
        if(companyService.findByid(companyId)!=null ){
            updatedreview.setCompany(companyService.findByid(companyId));
            updatedreview.setId(reviewId);
            reviewRepo.save(updatedreview);
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean deletereview(Long companyId, Long reviewId) {
        if(companyService.findByid(companyId)!=null && reviewRepo.existsById(reviewId)){
            Review review=reviewRepo.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReview().remove(review);
            review.setCompany(null);
            companyService.updatecompany( companyId,company);
            reviewRepo.deleteById(reviewId);
            return true;
        }

        return false;
    }


}
