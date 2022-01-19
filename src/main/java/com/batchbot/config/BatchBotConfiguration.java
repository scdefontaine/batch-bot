package com.batchbot.config;

import com.batchbot.dbo.CaseDBO;
import com.batchbot.dto.CaseDTO;
import com.batchbot.listener.JobCompletionListener;
import com.batchbot.processor.RecordItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchBotConfiguration {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BatchBotConfiguration(
            JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public FlatFileItemReader<CaseDTO> reader() {
        return new FlatFileItemReaderBuilder<CaseDTO>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName", "eyeColor", "hairColor"})
                .fieldSetMapper(
                        new BeanWrapperFieldSetMapper<CaseDTO>() {{ setTargetType(CaseDTO.class); }})
                .build();
    }

    @Bean
    public RecordItemProcessor processor() {
        return new RecordItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<CaseDBO> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CaseDBO>()
                .itemSqlParameterSourceProvider(
                        new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO CASE_TABLE (FIRST_NAME, LAST_NAME, EYE_COLOR, HAIR_COLOR)" +
                        "VALUES (:firstName, :lastName, :eyeColor, :hairColor)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<CaseDBO> writer) {
        return stepBuilderFactory.get("step1")
                .<CaseDTO, CaseDBO> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
