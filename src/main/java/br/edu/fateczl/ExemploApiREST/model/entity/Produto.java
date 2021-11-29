package br.edu.fateczl.ExemploApiREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
//@NamedStoredProcedureQuery(
//		name = "Produto.spXxxx",
//		procedureName = "sp_xxx",
//		parameters = {
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Param1", type = Integer.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Param2", type = Integer.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Param3", type = String.class),
//			@StoredProcedureParameter(mode = ParameterMode.IN, name = "Param4", type = Integer.class),
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "Param5", type = String.class),
//		}
//		)
//@NamedNativeQuery(//UDF, View, Query mais sofisticada
//		name = "Produto.fnYyyy",
//		query = "SELECT id, nome, valor FROM fn_yyyy",
//		resultClass = Produto.class
//		)
public class Produto {

	@Id
	@Column
	private int id;
	@Column
	private String nome;
	@Column
	private float valor;
//	@ManyToOne(targetEntity = Fornecedor.class)
//	@JoinColumn(name = "forn")
//	private Fornecedor fornecedor
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
	
}
