
public class ItemAVL extends No {
	private int FB = 0;

	public ItemAVL(Object key) {
		super();
		this.setChave(key);
	}

	public ItemAVL() {
		super();
	}

	public int getFB() {
		return FB;
	}

	public void setFB(int fB) {
		FB = fB;
	}


	public boolean ehExterno() {
		System.out.println("metodo eh externo");
		
		return  (this.getFilhoEsquerdo() == null || this.getFilhoDireito() == null);
	}

	
	




}
