import java.util.Locale;
import java.util.Scanner;

public class resolucao {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		int N, opcao;
		double codigo[], preco[], quantidade[];
		String descricao[];

		System.out.print("Quantidade de produtos para digitar: ");
		N = sc.nextInt();

		codigo = new double[N];
		descricao = new String[N];
		preco = new double[N];
		quantidade = new double[N];

		tabelaProdutos(codigo, descricao, preco, quantidade);
		menu();
		opcao = sc.nextInt();

		while (opcao != 7) {

			if (opcao == 1) {
				imprimeTabela(codigo, descricao, preco, quantidade);
			} else if (opcao == 2) {
				pesquisaProduto(codigo, descricao, preco, quantidade);
			} else if (opcao == 3) {
				maiorPreco(codigo, descricao, preco, quantidade);
			} else if (opcao == 4) {
				menorQ10(codigo, descricao, quantidade);
			} else if (opcao == 5) {
				ativoEstoque(preco, quantidade);
			} else if (opcao == 6) {
				venda(codigo, preco, quantidade);
			}
			System.out.println();
			menu();
			opcao = sc.nextInt();
		}

	}

	/**
	 * pega os dados da tabela de produtos
	 * 
	 * @param a
	 *            vetor do código do produto
	 * @param b
	 *            vetor da descrição do produto
	 * @param c
	 *            vetor do preço do produto
	 * @param d
	 *            vetor da quantidade do produto
	 */
	public static void tabelaProdutos(double a[], String b[], double c[], double d[]) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(new Locale("en", "US"));
		sc.useLocale(Locale.ENGLISH);

		int i;

		for (i = 0; i < a.length; i++) {
			System.out.print("Digite o código do " + (i + 1) + "º produto: ");
			a[i] = sc.nextDouble();
			System.out.print("Digite o nome do " + (i + 1) + "º produto: ");
			b[i] = sc.next();
			System.out.print("Digite o preço do " + (i + 1) + "º produto: ");
			c[i] = sc.nextDouble();
			System.out.print("Digite o estoque do " + (i + 1) + "º produto: ");
			d[i] = sc.nextDouble();
		}
	}

	/**
	 * imprime menu para o usuário
	 */
	public static void menu() {
		System.out.println("1 – Imprimir tabela");
		System.out.println("2 – Pesquisar produto");
		System.out.println("3 – Mostrar dados do produto mais caro");
		System.out.println("4 – Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10");
		System.out.println("5 – Ativo total do estoque");
		System.out.println("6 - Efetuar uma venda");
		System.out.println("7 - Sair");
	}

	/**
	 * imprime a tabela dos produtos digitados pelo usuário opçao 1
	 * 
	 * @param a
	 *            código do produto
	 * @param b
	 *            descrição do produto
	 * @param c
	 *            preço do produto
	 * @param d
	 *            estoque do produto
	 * @param N
	 *            valor digitado pelo usuario
	 */
	public static void imprimeTabela(double[] a, String[] b, double[] c, double[] d) {
		System.out.println("| Código    | Descrição | Preço     | Quantidade");

		int i;

		for (i = 0; i < a.length; i++) {
			System.out.println("  " + a[i] + "         " + b[i] + "         " + c[i] + "         " + d[i]);
		}
	}

	/**
	 * pesquisa de produto por código opção 2
	 * 
	 * @param a
	 *            imprime o código do produto
	 * @param b
	 *            imprime a descrição do produto
	 * @param c
	 *            imprime o preço do produto
	 * @param d
	 *            imprime o estoque do produto
	 */
	public static void pesquisaProduto(double a[], String b[], double c[], double d[]) {
		Scanner sc = new Scanner(System.in);

		int p, cont = 0, i;

		System.out.print("Digite o código do produto desejado: ");
		p = sc.nextInt();

		for (i = 0; i < a.length; i++) {
			if (p == a[i]) {
				System.out.println("Código\tDescrição\tPreço\tQuantidade\tPreçoXqtd");
				System.out.println(a[i] + "\t" + b[i] + "\t" + c[i] + "\t" + d[i] + "\t" + (c[i] * d[i]));
			} else if (p != a[i]) {
				cont++;
			}
		}
		if (cont == a.length) {
			System.out.println("Produto inexistente.");
		}
	}

	/**
	 * imprime o produto mais caro opção 3
	 * 
	 * @param a
	 *            imprime o código do produto
	 * @param b
	 *            imprime a descrição do produto
	 * @param c
	 *            imprime o preço do produto
	 * @param d
	 *            imprime o estoque do produto
	 */
	public static void maiorPreco(double a[], String b[], double c[], double d[]) {

		int i, cont2 = 0;
		double cont = 0;

		for (i = 0; i < c.length; i++) {
			if (c[i] > cont) {
				cont = c[i];
				cont2 = i;
			}
		}
		System.out.println("Código\tDescrição\tPreço\tQuantidade");
		System.out.println(a[cont2] + "\t" + b[cont2] + "\t" + c[cont2] + "\t" + d[cont2]);
	}

	/**
	 * imprime lista de produtos que estão com estoque abaixo de 10 opção 4
	 * 
	 * @param a
	 *            código do produto
	 * @param b
	 *            descrição do produto
	 * @param d
	 *            estoque do produto (para comparação)
	 */
	public static void menorQ10(double a[], String b[], double d[]) {
		System.out.println("Produtos com estoque abaixo de 10");
		System.out.println("| Código    | Descrição");
		for (int i = 0; i < a.length; i++) {
			if (d[i] < 10) {
				System.out.println("  " + a[i] + "         " + b[i]);
			}
		}
	}

	/**
	 * imprime o ativo total do estoque opção 5
	 * 
	 * @param c
	 *            preço do produto
	 * @param d
	 *            estoque do produto
	 */
	public static void ativoEstoque(double c[], double d[]) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		int i;
		double ativo = 0, soma;

		System.out.print("Ativo  total  do  estoque: ");

		for (i = 0; i < c.length; i++) {
			soma = c[i] * d[i];
			ativo = ativo + soma;
		}
		System.out.println(ativo);
	}

	/**
	 * efetua a venda do produto opção 6
	 * 
	 * @param a
	 *            código do produto
	 * @param c
	 *            preço do produto
	 * @param d
	 *            estoque do produto
	 */
	public static void venda(double a[], double c[], double d[]) {
		Scanner sc = new Scanner(System.in);

		int i,p, qtdVenda, cont = 0;
		System.out.print("Digite o código do produto: ");
		p=sc.nextInt();
		for (i = 0; i < a.length; i++) {
			if (p == a[i]) {
				System.out.print("Qual a quantidade do produto: ");
				qtdVenda = sc.nextInt();
				if (d[i] - qtdVenda < 0){
					System.out.println("Quantidade insuficiente");
				} else {
					d[i] = d[i] - qtdVenda;
					System.out.println("Venda realizada com sucesso!");
				}
			} else {
				cont++;
			}
		}
		
		if (cont == a.length) {
			System.out.println("Código inexistente");
		}
	}
}
