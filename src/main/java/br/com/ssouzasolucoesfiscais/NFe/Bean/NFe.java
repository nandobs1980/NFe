package br.com.ssouzasolucoesfiscais.NFe.Bean;

import java.util.ArrayList;
import java.util.List;

public class NFe {

	private Ide ide = new Ide();
	private Emit emit = new Emit();
	private Dest dest = new Dest();
	private Avulsa avulsa = new Avulsa();
	private List<Prod> list_prod = new ArrayList<Prod>(); 
	private ICMSTot icmsTot = new ICMSTot();
	private ISSQNtot issqnTot = new ISSQNtot();
	public Ide getIde() {
		return ide;
	}
	public void setIde(Ide ide) {
		this.ide = ide;
	}
	public Emit getEmit() {
		return emit;
	}
	public void setEmit(Emit emit) {
		this.emit = emit;
	}
	public Dest getDest() {
		return dest;
	}
	public void setDest(Dest dest) {
		this.dest = dest;
	}
	public Avulsa getAvulsa() {
		return avulsa;
	}
	public void setAvulsa(Avulsa avulsa) {
		this.avulsa = avulsa;
	}
	public List<Prod> getList_prod() {
		return list_prod;
	}
	public void setList_prod(List<Prod> list_prod) {
		this.list_prod = list_prod;
	}
	public ICMSTot getIcmsTot() {
		return icmsTot;
	}
	public void setIcmsTot(ICMSTot icmsTot) {
		this.icmsTot = icmsTot;
	}
	public ISSQNtot getIssqnTot() {
		return issqnTot;
	}
	public void setIssqnTot(ISSQNtot issqnTot) {
		this.issqnTot = issqnTot;
	}
}
