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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MTXTB044_LOTE_CONTROLE")
@NamedQueries({
	@NamedQuery(name = "Mtxtb044LoteControle.buscaPorNSU", query = "SELECT m FROM Mtxtb044LoteControle m where m.nuNsuLoteControle = :NSU"),
	@NamedQuery(name = "Mtxtb044LoteControle.findAll", query = "SELECT m FROM Mtxtb044LoteControle m")
})
public class Mtxtb044LoteControle implements Serializable {
	private static final long serialVersionUID = -2112239096284881436L;

	@Id
	@Column(name = "NU_NSU_LOTE_CONTROLE", unique = true, nullable = false)
    private long nuNsuLoteControle;
	
	@Column(name = "NU_NSU_LOTE_CANAL", nullable = true)
	private long nuNSULoteCanal;
	
	@Column(name = "DT_REFERENCIA", nullable = false)
	private Date dtReferencia;
	
	@Column(name = "IC_SITUACAO_LOTE", nullable = false)
	private int icSituacaoLote;
	
	@Column(name = "NU_CANAL", nullable = false)
	private int nuCanal;
	
	@Column(name = "VR_LOTE", nullable = true)
	private BigDecimal vrLote;
	
	@Column(name = "IC_TIPO_DEBITO", nullable = false)
	private int icTipoDebito;
	
	@Column(name = "IC_TIPO_LOTE", nullable = false)
	private int icTipoLote;
	
	@Column(name = "IC_CONTA_SOLUCAO", nullable = false)
	private int icContaSolucao;
	
	@Column(name = "NU_UNIDADE", nullable = false)
	private int nuUnidade;
	
	@Column(name = "NU_PRODUTO", nullable = false)
	private int nuProduto;
	
	@Column(name = "NU_CONTA", nullable = false)
	private long nuConta;
	
	@Column(name = "NU_DV_CONTA", nullable = false)
	private int nuDvConta;
	
	@Column(name = "DE_XML_RECEBIMENTO", nullable = false)
	private String deXmlRecebimento;
	
	@Column(name = "DE_XML_RESPOSTA", nullable = true)
	private String deXmlResposta;
	
	
	public long getNuNsuLoteControle() {
		return nuNsuLoteControle;
	}
	public void setNuNsuLoteControle(long nuNsuLoteCanal) {
		this.nuNsuLoteControle = nuNsuLoteCanal;
	}
	public long getNuNSULoteCanal() {
		return nuNSULoteCanal;
	}
	public void setNuNSULoteCanal(long nuNSULoteCanal) {
		this.nuNSULoteCanal = nuNSULoteCanal;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public int getIcSituacaoLote() {
		return icSituacaoLote;
	}
	public void setIcSituacaoLote(int icSituacaoLote) {
		this.icSituacaoLote = icSituacaoLote;
	}
	public int getNuCanal() {
		return nuCanal;
	}
	public void setNuCanal(int nuCanal) {
		this.nuCanal = nuCanal;
	}
	public BigDecimal getVrLote() {
		return vrLote;
	}
	public void setVrLote(BigDecimal vrLote) {
		this.vrLote = vrLote;
	}
	public int getIcTipoDebito() {
		return icTipoDebito;
	}
	public void setIcTipoDebito(int icTipoDebito) {
		this.icTipoDebito = icTipoDebito;
	}
	public int getIcTipoLote() {
		return icTipoLote;
	}
	public void setIcTipoLote(int icTipoLote) {
		this.icTipoLote = icTipoLote;
	}
	public int getIcContaSolucao() {
		return icContaSolucao;
	}
	public void setIcContaSolucao(int icContaSolucao) {
		this.icContaSolucao = icContaSolucao;
	}
	public int getNuUnidade() {
		return nuUnidade;
	}
	public void setNuUnidade(int nuUnidade) {
		this.nuUnidade = nuUnidade;
	}
	public int getNuProduto() {
		return nuProduto;
	}
	public void setNuProduto(int nuProduto) {
		this.nuProduto = nuProduto;
	}
	public long getNuConta() {
		return nuConta;
	}
	public void setNuConta(long nuConta) {
		this.nuConta = nuConta;
	}
	public int getNuDvConta() {
		return nuDvConta;
	}
	public void setNuDvConta(int nuDvConta) {
		this.nuDvConta = nuDvConta;
	}
	public String getDeXmlRecebimento() {
		return deXmlRecebimento;
	}
	public void setDeXmlRecebimento(String deXmlRecebimento) {
		this.deXmlRecebimento = deXmlRecebimento;
	}
	public String getDeXmlResposta() {
		return deXmlResposta;
	}
	public void setDeXmlResposta(String deXmlResposta) {
		this.deXmlResposta = deXmlResposta;
	}
	
	

}
