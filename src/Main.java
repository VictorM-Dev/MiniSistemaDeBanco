import java.util.Scanner;

class Banco{
    private double saldo = 0;
    private double taxaDeJuros = 0;

    //Métodos set
    public void setSaldo(double saldoRecebido){
        saldo = saldoRecebido;
    }
    public void setTaxaDeJuros(double taxaDeJurosRecebida){
        taxaDeJuros = taxaDeJurosRecebida;
    }

    //Métodos get
    public double getSaldo(){
        return saldo;
    }
    public double getTaxaDeJuros(){
        return taxaDeJuros;
    }

    //Métodos de operação
    public void realizarDeposito(double deposito){
        saldo += deposito;
    }
    public void realizarSaque(double saque){
        saldo -= saque;
    }
    public void realizarRendimentoMensal(){
        saldo += saldo*(taxaDeJuros/100);
    }
    public void exibirSaldo(){
        System.out.printf("O saldo da sua conta é de %.2f, e renderá uma taxa de: %.2f%% ao mês.", saldo, taxaDeJuros);
    }

}
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Banco myCount = new Banco();

        int opcao = 1;
        while(opcao != 0){
            System.out.println("\n1 - Informe seu saldo");
            System.out.println("2 - Informe a taxa de rendimento");
            System.out.println("3 - Depositar valor");
            System.out.println("4 - Sacar valor");
            System.out.println("5 - Verificar saldo e rendimento");
            System.out.println("6 - Avançar um mês");
            System.out.println("0 - Encerrar programa");

            opcao = input.nextInt();
            switch (opcao){
                case 1:
                    System.out.print("\nInforme seu saldo: ");
                    myCount.setSaldo(input.nextDouble());
                    break;
                case 2:
                    System.out.print("\nInforme a taxa de rendimento: ");
                    myCount.setTaxaDeJuros(input.nextDouble());
                    break;
                case 3:
                    System.out.print("\nInforme o valor do depósito: ");
                    myCount.realizarDeposito(input.nextDouble());
                    break;
                case 4:
                    System.out.print("\nInforme o valor do saque: ");
                    myCount.realizarSaque(input.nextDouble());
                    break;
                case 5:
                    myCount.exibirSaldo();
                    break;
                case 6:
                    myCount.realizarRendimentoMensal();
                    System.out.println("Ao passar um mês!");
                    myCount.exibirSaldo();
                    break;
                default:
                    if(opcao != 0) System.out.println("Informe uma opção válida");
                    break;
            }
        }
    }
}