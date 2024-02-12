package jefdev.lojavirtual.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jefdev.lojavirtual.enums.TipoEndereco;

@Entity
@Table(name="endereco")
@SequenceGenerator(name="seq_endereco", sequenceName="seq_endereco", initialValue=1, allocationSize=1)
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_endereco")
	private Long id;
	
	private String ruaLogra;
	private String cep;
	private String nemero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="pessoa_id", nullable=false, foreignKey=@ForeignKey(name="pessoa_fk", value=ConstraintMode.CONSTRAINT))
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuaLogra() {
		return ruaLogra;
	}

	public void setRuaLogra(String ruaLogra) {
		this.ruaLogra = ruaLogra;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNemero() {
		return nemero;
	}

	public void setNemero(String nemero) {
		this.nemero = nemero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}
