
public class AVL {
	private ItemAVL raiz;
	public Comparador comparador;
	
	public AVL(Comparador c) {
		super();
		this.comparador = c;
	}
	
	public AVL() {
		super();		
	
	}

	public ItemAVL inserir(Object key) {
		if(this.isEmpty()){
			this.raiz = new ItemAVL(key);
			return raiz;
		}else{
			
		}
		return null;
	}

	public boolean isEmpty() {
		return this.raiz == null;
	}

	public Object remover(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemAVL getRaiz() {
		
		return this.raiz;
	}

	

	public void mostra(ItemAVL no, int i) {
		
		if(no!=null){	
            mostra((ItemAVL)no.getFilhoDireito(),i+1);            
            System.out.print("\n");
        	for(int f = 1; f <= i ; f++)
        	    System.out.print("   ");
        	System.out.print(no.getChave()+"["+no.getFB()+"]");
        	mostra((ItemAVL)no.getFilhoEsquerdo(),i+1);	
        }
	}

	public void mostraArvore(ItemAVL raiz2, int i) {
		// TODO Auto-generated method stub
		
	}

}
