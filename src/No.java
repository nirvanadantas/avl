
public class No {

	private No filhoDireito;
	private No filhoEsquerdo;
	private No pai = null;
	private Object chave;
	
	
	public No( Object chave) {
		super();
		this.chave = chave;
		this.setFilhoDireito(null);
		this.setFilhoEsquerdo(null);
		
	}
	
	
	public No() {
		super();		
	}
	
	public No getFilhoDireito() {
		return filhoDireito;
	}
	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	public No getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	public Object getChave() {
		return chave;
	}
	public void setChave(Object chave) {
		this.chave = chave;
	}
	
	

}
