package jefdev.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "avalicao_produto")
@SequenceGenerator(name="seq_avalicao_produto", sequenceName="seq_avalicao_produto", initialValue=1, allocationSize=1)
public class AvaliacaProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avalicao_produto")
	private Long id;
	
	private String descricao;
	private Integer nota;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="pessoa_id", nullable=false,
	foreignKey=@ForeignKey(name="pessoa_fk", value=ConstraintMode.CONSTRAINT))
	private Pessoa pessoa;
	
	@ManyToOne(targetEntity=Produto.class)
	@JoinColumn(name="produto_id", nullable=false,
	foreignKey=@ForeignKey(name="produto_fk", value=ConstraintMode.CONSTRAINT))
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaProduto other = (AvaliacaProduto) obj;
		return Objects.equals(id, other.id);
	}
	
}
