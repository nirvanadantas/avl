
public class AVL extends ItemAVL{
	private ItemAVL raiz;
	public Comparador comparador;

	public AVL(Comparador c) {
		super();
		this.comparador = c;
	}

	public AVL() {
		super();
		this.comparador = new Comparador();

	}

	public ItemAVL inserir(Object key) {
		ItemAVL n = new ItemAVL(key);
		return inserirAvl(this.raiz, n);
	}

	private ItemAVL inserirAvl(ItemAVL esse, ItemAVL novo) {

		if(esse == null){
			this.raiz = novo;
			System.out.println("inserindo "+raiz.getChave()+" na raiz");
			return raiz;
		}else{
			if(comparador.comparar(esse.getChave(), novo.getChave()) < 0){
				if(esse.getFilhoEsquerdo() == null){
					esse.setFilhoEsquerdo(novo);
					novo.setPai(esse);
					atualizaFBantecessorInsercao(novo);
					rebalanceia((ItemAVL) novo);
				}else{
					inserirAvl((ItemAVL)esse.getFilhoEsquerdo(), novo);
				}
			}else{

				if(esse.getFilhoDireito() == null){
					esse.setFilhoDireito(novo);
					novo.setPai(esse);

				}else{
					inserirAvl((ItemAVL)esse.getFilhoDireito(), novo);
				}

			}

			return novo;

		}
	}

	private void atualizaFBantecessorInsercao(ItemAVL novo) {
		if(novo.getPai() == null){


		}else if(novo.getPai() != null){

			if(novo.getPai().getFilhoDireito() == novo){//sendofilho direito incrementa

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() - 1);

			}else{

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() + 1);

			}

			atualizaFBantecessorInsercao((ItemAVL) novo.getPai());

		}else if (((ItemAVL) novo.getPai()).getFB() == 0 ) {

			if(novo.getPai().getFilhoDireito() == novo){

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() - 1);

			}else{

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() + 1);

			}
		}


	}
	private void atualizaFBantecessorRemocao(ItemAVL novo) {
		if(novo.getPai() != null){

			if(novo.getPai().getFilhoDireito() == novo){//sendofilho direito incrementa

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() + 1);

			}else{

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() - 1);

			}

			atualizaFBantecessorInsercao((ItemAVL) novo.getPai());

		}else if (((ItemAVL) novo.getPai()).getFB() != 0 ) {

			if(novo.getPai().getFilhoDireito() == novo){

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() + 1);

			}else{

				((ItemAVL) novo.getPai()).setFB(((ItemAVL) novo.getPai()).getFB() - 1);

			}
		}
	}

	private void rebalanceia(ItemAVL novo) {
		if(novo.getFB() == 2){

			if(((ItemAVL) novo.getFilhoEsquerdo()).getFB() < 0){
				novo = rotacaoDireitaDupla(novo);
			}else{
				novo = rotacaoDireita(novo);
			}

		}else if(novo.getFB() == -2){

			if(((ItemAVL) novo.getFilhoDireito()).getFB() > 0){
				novo = rotacaoEsquerdaDupla(novo);
			}else{
				novo = rotacaoEsquerda(novo);
			}


		}

		if(novo.getPai() != null){
			rebalanceia((ItemAVL)novo.getPai());
		}else{

		}

	}

	private ItemAVL rotacaoEsquerda(ItemAVL antiga) {
		ItemAVL nova = (ItemAVL) antiga.getFilhoDireito();
		nova.setPai(antiga.getPai());

		antiga.setFilhoDireito(nova.getFilhoEsquerdo());//guardei a arvore

		if(antiga.getFilhoDireito() != null){
			antiga.getFilhoDireito().setPai(antiga);
		}

		nova.setFilhoEsquerdo(antiga);
		antiga.setPai(nova);

		if(nova.getPai()!= null){
			if(nova.getPai().getFilhoDireito() == antiga){
				nova.getPai().setFilhoDireito(nova);
			}else if(nova.getPai().getFilhoEsquerdo() == antiga){
				nova.getPai().setFilhoEsquerdo(nova);
			}
		}

		//como atualizar FB depois de rotacao?

		return nova;
	}

	private ItemAVL rotacaoEsquerdaDupla(ItemAVL antiga) {
		antiga.setFilhoDireito(rotacaoDireita((ItemAVL) antiga.getFilhoDireito()));
		return rotacaoEsquerda(antiga);
	}

	private ItemAVL rotacaoDireitaDupla(ItemAVL antiga) {
		antiga.setFilhoEsquerdo(rotacaoEsquerda((ItemAVL) antiga.getFilhoEsquerdo()));
		return rotacaoDireita(antiga);
	}

	private ItemAVL rotacaoDireita(ItemAVL antiga) {
		ItemAVL nova = (ItemAVL) antiga.getFilhoEsquerdo();//arvore q vai ficar no lugar da antiga depois da rotacao
		nova.setPai(antiga.getPai());

		antiga.setFilhoEsquerdo(nova.getFilhoDireito());

		if(antiga.getFilhoEsquerdo() != null){
			antiga.getFilhoEsquerdo().setPai(antiga);
		}

		nova.setFilhoDireito(antiga);
		antiga.setPai(nova);

		if(nova.getPai() != null){

			if(nova.getPai().getFilhoDireito() == antiga){
				nova.getPai().setFilhoDireito(nova);
			}else if(nova.getPai().getFilhoEsquerdo() == antiga){
				nova.getPai().setFilhoEsquerdo(nova);
			}

		}
		//como atualizar FB depois de rotacao?

		return nova;
	}

	public ItemAVL busca(Object key) {
		System.out.println("caminho");
		if(this.ehExterno())
			return (AVL)this;
		else if(comparador.comparar(this.getChave(), key) >= 0)//this.getChave() >= key)
			return ((AVL) this.getFilhoDireito()).busca(key);
		else if(comparador.comparar(this.getChave(), key) < 0)//(this.getChave() < key)
			return (((AVL) this.getFilhoEsquerdo()).busca(key));
		else
			return (AVL) this;



	}

	public boolean isEmpty() {
		return this.raiz == null;
	}

	public Object remover(Object key) {

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
		this.mostra(raiz2, i);

	}

}
