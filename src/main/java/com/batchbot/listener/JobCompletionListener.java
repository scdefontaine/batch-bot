package com.batchbot.listener;

import com.batchbot.dbo.CaseDBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! TIME TO VERIFY RESULTS !!!");

            jdbcTemplate.query(
                    "SELECT FIRST_NAME, LAST_NAME, EYE_COLOR, HAIR_COLOR FROM CASE_TABLE",
                    (rs, row) -> new CaseDBO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4))
            ).forEach(caseDBO -> log.info("Found <" + caseDBO + "> in the database."));
        }
    }
}
