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
@Table(name = "item_venda_loja")
@SequenceGenerator(name="seq_item_venda_loja", sequenceName="seq_item_venda_loja", initialValue=1, allocationSize=1)
public class ItemVendaLoja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_venda_loja")
	private Long id;
	
	@ManyToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="produto_id", nullable=false, 
	foreignKey=@ForeignKey(name="produto_fk", value=ConstraintMode.CONSTRAINT))
	private Produto produto;
	
	@ManyToOne(targetEntity=NotaFiscalVenda.class)
	@JoinColumn(name="venda_compra_loja_virtual_id", nullable=false,
	foreignKey=@ForeignKey(name="venda_compra_loja_virtual_fk", value=ConstraintMode.CONSTRAINT))
	private VendaCompraLojaVirtual vendaCompraLojaVirtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaCompraLojaVirtual getVendaCompraLojaVirtual() {
		return vendaCompraLojaVirtual;
	}

	public void setVendaCompraLojaVirtual(VendaCompraLojaVirtual vendaCompraLojaVirtual) {
		this.vendaCompraLojaVirtual = vendaCompraLojaVirtual;
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
		ItemVendaLoja other = (ItemVendaLoja) obj;
		return Objects.equals(id, other.id);
	}
	
}
