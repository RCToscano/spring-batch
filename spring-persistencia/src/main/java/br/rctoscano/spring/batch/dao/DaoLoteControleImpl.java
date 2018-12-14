package br.rctoscano.spring.batch.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.rctoscano.spring.batch.entidade.Mtxtb044LoteControle;



@Stateless
public class DaoLoteControleImpl {

	@PersistenceContext(name = "simtx_dao", unitName = "simtx_dao")
	private EntityManager em;

	public void salvar(Mtxtb044LoteControle loteControle) {
		this.em.persist(loteControle);
		this.em.flush();
	}

	public Mtxtb044LoteControle buscaPorNSU(long nsu) {
		return this.em.createNamedQuery("Mtxtb044LoteControle.buscaPorNSU", Mtxtb044LoteControle.class)
				.setParameter("NSU", nsu).getSingleResult();
	}

	public List<Mtxtb044LoteControle> listaTodos() {
		return this.em.createNamedQuery("Mtxtb044LoteControle.findAll", Mtxtb044LoteControle.class)
				.getResultList();
	}

	public void alteraLote(Mtxtb044LoteControle lote) {
		this.em.merge(lote);
		this.em.flush();
	}

}
