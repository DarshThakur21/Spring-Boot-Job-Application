package com.company.first_jobappproject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob( Job job);

    Job findBYid(Long id);


    boolean deleteByid(Long id);

    boolean updatejob(Long id, Job updatedjob);
}
