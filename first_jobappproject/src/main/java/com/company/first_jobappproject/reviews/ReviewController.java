package com.company.first_jobappproject.reviews;


import com.company.first_jobappproject.Company.Company;
import com.company.first_jobappproject.Company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
        private ReviewService reviewService;


    public ReviewController(ReviewService reviewService,CompanyService companyService) {
        this.reviewService = reviewService;

    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getallreviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getallreviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public  ResponseEntity<String> addreveiew(@RequestBody Review review,@PathVariable Long companyId){

            boolean isreviewsaved=reviewService.addreview(companyId,review);
            if(isreviewsaved){

        return new ResponseEntity<>("review added",HttpStatus.CREATED);
            }
        return new ResponseEntity<>("review not saved",HttpStatus.NOT_FOUND );


    }

    @GetMapping("/reviews/{reviewsId}")
    public ResponseEntity<Review> getreview(@PathVariable Long companyId,@PathVariable Long reviewsId){
            return new ResponseEntity<>( reviewService.getreview(companyId,reviewsId),HttpStatus.OK);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String > updatereview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId,
                                                @RequestBody Review review){
        boolean isreviewupdate=reviewService.updatereview(companyId,reviewId,review);
        if(isreviewupdate){
            return new ResponseEntity<>("review updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("No update taken ",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deletereview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){

        boolean isreviewdeleted=reviewService.deletereview(companyId,reviewId);

        if(isreviewdeleted){
            return new ResponseEntity<>("review deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("NO Delete",HttpStatus.NOT_FOUND);
    }


}
