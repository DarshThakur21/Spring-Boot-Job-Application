package com.company.first_jobappproject.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {

    private  JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping
     ResponseEntity<List<Job>> findAll(){
        return  new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity <Job> findByid(@PathVariable Long id){
            Job job=jobService.findBYid(id);
                if(job==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

        return new ResponseEntity<>(job, HttpStatus.OK);

    }


        @PostMapping
        public ResponseEntity<String> createJob(@RequestBody  Job job){
            jobService.createJob(job);
            return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
//            return  ResponseEntity.created("Job added successfully");
        }

//        @DeleteMapping("/jobs/{id}")
//        public ResponseEntity<String> deleteByid(@PathVariable Long id){
//                  jobService.deleteByid(id);
//                  return new ResponseEntity<>("Deleted",HttpStatus.OK);
//
//        }
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteByid(@PathVariable Long id){
                  boolean deleted=jobService.deleteByid(id);
                  if(deleted) {
                      return new ResponseEntity<>("Deleted", HttpStatus.OK);
                  }
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }


        @PutMapping("/{id}")
        public ResponseEntity<String> updatejob(@PathVariable Long id,@RequestBody Job updatedjob){
            boolean update=jobService.updatejob(id,updatedjob);
            if(update){
                return new ResponseEntity<>("updated",HttpStatus.OK);
            }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }



}


//[{
//        "id":1,
//        "title":"sde",
//        "description":"build software",
//        "minSalary":"10k",
//        "maxSalary":"100k",
//        "location":"pune"
//        },
//        {
//        "id":2,
//        "title":"sde-intern",
//        "description":" software",
//        "minSalary":"1k",
//        "maxSalary":"10k",
//        "location":"hyderabad"
//        },
//        {
//        "id":3,
//        "title":"de",
//        "description":"build",
//        "minSalary":"10",
//        "maxSalary":"1",
//        "location":"un"
//        },
//        {
//        "id":4,
//        "title":"cyc",
//        "description":" peon",
//        "minSalary":"10k",
//        "maxSalary":"20k",
//        "location":"pune"
//        }
//        ]
