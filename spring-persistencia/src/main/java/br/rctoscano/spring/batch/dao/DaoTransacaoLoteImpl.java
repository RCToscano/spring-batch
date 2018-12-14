package br.rctoscano.spring.batch.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import br.rctoscano.spring.batch.entidade.Mtxtb045TransacaoLote;
import br.rctoscano.spring.batch.main.ProcessoBatch;



@Stateless
@Configuration
@EnableBatchProcessing
public class DaoTransacaoLoteImpl {

	@PersistenceContext(name = "simtx_dao", unitName = "simtx_dao")
	private EntityManager em;

	public void salvar(Mtxtb045TransacaoLote transacaoLote) {
		this.em.persist(transacaoLote);
		this.em.flush();
	}

	public Mtxtb045TransacaoLote buscaPorNSU(long nsu) {
		return this.em.createNamedQuery("Mtxtb045TransacaoLote.buscaPorNSU", Mtxtb045TransacaoLote.class)
				.setParameter("NSU", nsu).getSingleResult();
	}

	public List<Mtxtb045TransacaoLote> listaTodos() {
		return this.em.createNamedQuery("Mtxtb045TransacaoLote.findAll", Mtxtb045TransacaoLote.class)
				.getResultList();
	}

	public void alteraTransacao(Mtxtb045TransacaoLote transacao) {
		this.em.merge(transacao);
		this.em.flush();
	}

	
	
	@Bean
	public FlatFileItemReader<Mtxtb045TransacaoLote> reader() {
		FlatFileItemReader<Mtxtb045TransacaoLote> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("sample-data.csv"));
		reader.setLineMapper(new DefaultLineMapper<Mtxtb045TransacaoLote>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "name", "car" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Mtxtb045TransacaoLote>() {
					{
						setTargetType(Mtxtb045TransacaoLote.class);
					}
				});
			}
		});
		return reader;
	}
	
	@Bean
    public ProcessoBatch processor() {
		return new ProcessoBatch();
	}
	
	@Bean
	public JdbcBatchItemWriter<Mtxtb045TransacaoLote> writer() {
		JdbcBatchItemWriter<Mtxtb045TransacaoLote> writer = new JdbcBatchItemWriter<>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("INSERT INTO autobot (name, car) VALUES (:name, :car)");
		writer.setDataSource(this.dataSource);
		return writer;
	}
	
	@Bean
    public Job importAutobotJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importAutobotJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Autobot, Autobot>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
	
}
