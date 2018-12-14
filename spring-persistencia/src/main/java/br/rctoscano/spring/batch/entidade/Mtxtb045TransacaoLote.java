/*******************************************************************************
 * Copyright (C)  2017 - CAIXA Econômica Federal 
 * 
 * Todos os direitos reservados
 ******************************************************************************/

package br.rctoscano.spring.batch.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MTXTB045_TRANSACAO_LOTE")
@NamedQueries({
	@NamedQuery(name = "Mtxtb045TransacaoLote.buscaPorNSU", query = "SELECT m FROM Mtxtb045TransacaoLote m where m.nuNsuTransacaoLote = :NSU"),
	@NamedQuery(name = "Mtxtb045TransacaoLote.findAll", query = "SELECT m FROM Mtxtb045TransacaoLote m")
})
public class Mtxtb045TransacaoLote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="NU_NSU_LOTE_CONTROLE", unique = true, nullable = false)
    private long nuNsuLoteControle;
    
    @Id
    @Column(name = "NU_NSU_TRANSACAO_LOTE", unique = true, nullable = false)
    private long nuNsuTransacaoLote;
    
    @Column(name = "NU_NSU_TRANSACAO", nullable = true)
    private long nuNsuTransacao;
    
    @Column(name = "DT_REFERENCIA", nullable = false)
    private Date dtReferencia;
    
    @Column(name = "NU_NSU_CANAL", nullable = true)
    private long nuNsuCanal;
    
    @Column(name = "IC_SITUACAO_TRANSACAO", nullable = false)
    private int icSituacaoTransacao;
    
    @Column(name = "NU_SERVICO", nullable = false)
    private int nuServico;
    
    @Column(name = "NU_VERSAO_SERVICO", nullable = false)
    private int nuVersaoServico;
    
    @Column(name = "VR_TRANSACAO", nullable = true)
    private BigDecimal vrTransacao;
    
    @Column(name = "DE_XML_REQUISICAO", nullable = false)
    private String deXmlRequisicao;
    
    @Column(name = "DE_XML_RESPOSTA", nullable = true)
    private String deXmlResposta;

    @ManyToOne
    @JoinColumn(name = "NU_NSU_LOTE_CONTROLE", referencedColumnName = "NU_NSU_LOTE_CONTROLE", insertable = false, updatable = false) 
    private Mtxtb044LoteControle mtxtb044LoteControle;
    
	
	public long getNuNsuLoteControle() {
		return nuNsuLoteControle;
	}
	public void setNuNsuLoteControle(long nuNsuLoteControle) {
		this.nuNsuLoteControle = nuNsuLoteControle;
	}
	public Mtxtb044LoteControle getMtxtb044LoteControle() {
		return mtxtb044LoteControle;
	}
	public void setMtxtb044LoteControle(Mtxtb044LoteControle mtxtb044LoteControle) {
		this.mtxtb044LoteControle = mtxtb044LoteControle;
	}
	public long getNuNsuTransacaoLote() {
		return nuNsuTransacaoLote;
	}
	public void setNuNsuTransacaoLote(long nuNsuTransacaoLote) {
		this.nuNsuTransacaoLote = nuNsuTransacaoLote;
	}
	public long getNuNsuTransacao() {
		return nuNsuTransacao;
	}
	public void setNuNsuTransacao(long nuNsuTransacao) {
		this.nuNsuTransacao = nuNsuTransacao;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public long getNuNsuCanal() {
		return nuNsuCanal;
	}
	public void setNuNsuCanal(long nuNsuCanal) {
		this.nuNsuCanal = nuNsuCanal;
	}
	public int getIcSituacaoTransacao() {
		return icSituacaoTransacao;
	}
	public void setIcSituacaoTransacao(int icSituacaoTransacao) {
		this.icSituacaoTransacao = icSituacaoTransacao;
	}
	public int getNuServico() {
		return nuServico;
	}
	public void setNuServico(int nuServico) {
		this.nuServico = nuServico;
	}
	public int getNuVersaoServico() {
		return nuVersaoServico;
	}
	public void setNuVersaoServico(int nuVersaoServico) {
		this.nuVersaoServico = nuVersaoServico;
	}
	public BigDecimal getVrTransacao() {
		return vrTransacao;
	}
	public void setVrTransacao(BigDecimal vrTransacao) {
		this.vrTransacao = vrTransacao;
	}
	public String getDeXmlRequisicao() {
		return deXmlRequisicao;
	}
	public void setDeXmlRequisicao(String deXmlRequisicao) {
		this.deXmlRequisicao = deXmlRequisicao;
	}
	public String getDeXmlResposta() {
		return deXmlResposta;
	}
	public void setDeXmlResposta(String deXmlResposta) {
		this.deXmlResposta = deXmlResposta;
	}
	
}
