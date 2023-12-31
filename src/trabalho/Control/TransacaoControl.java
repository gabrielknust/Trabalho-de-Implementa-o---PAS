/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Control;

import java.util.HashMap;
import java.util.Scanner;
import static trabalho.Control.CompradorControl.caracteristicas;
import trabalho.Model.Corretor;
import trabalho.Model.Imovel;
import trabalho.Model.Transacao;

/**
 *
 * @author gabri
 */
public class TransacaoControl {
    static HashMap<Integer,Transacao> transacoes = new HashMap<Integer,Transacao>();
    static HashMap<Integer,Corretor> corretores = new HashMap<Integer,Corretor>();
    static Scanner sc = new Scanner(System.in);
    int codigo = 1;
    
    public static Transacao create(){
        System.out.print("Informe o codigo do Imovel: ");
        int codigoImovel = sc.nextInt();
        Imovel imovel = ImovelControl.read(codigoImovel);
        System.out.print("Informe o valor da transacao: ");
        float valor = sc.nextFloat();
        System.out.print("Informe o Email: ");
        String email = sc.nextLine();
        System.out.print("Informe o Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Informe o Endereco: ");
        String endereco = sc.nextLine();
        int controlador = 0;
        while(controlador !=9){
            System.out.println("Deseja adicionar ou remover corretores da transacao?");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("9 - Sair");
            controlador = sc.nextInt();
            if(controlador==1){
                adicionarCorretor(corretores);
            }else if(controlador==2){
                removerCorretor(corretores);
            }
        }
        Transacao transacao = new Transacao(codigoImovel, imovel, valor, corretores);
        return transacao;
    }
    public static Transacao read(int codigo){
        return transacoes.get(codigo);
    }
    public static HashMap<Integer,Transacao> readAll(){
        return transacoes;
    }
    public static void update(int codigo){
        Transacao transacao = transacoes.get(codigo);
        int indice = 0;
        int codigoImovel;
        System.out.println("Informe o que será alterado:");
        System.out.println("1:Codigo.");
        System.out.println("2:Valor.");
        System.out.println("3:Imovel.");
        System.out.println("4:Corretores.");
        indice = sc.nextInt();
        switch(indice){
        case 1:
            System.out.print("Informe o codigo: ");
            int codigoNovo = sc.nextInt();
            transacoes.remove(transacao.getCodigo());
            transacao.setCodigo(codigoNovo);
            transacoes.put(codigoNovo, transacao);
            break;
        case 2:
            System.out.print("Informe o Valor: ");
            float valor = sc.nextFloat();
            transacao.setValor(valor);
            break;
        case 3: 
            System.out.print("Informe o codigo do Imovel: ");
            codigoImovel = sc.nextInt();
            transacao.setImovel(ImovelControl.read(codigoImovel));
            break;
        case 4:
            int controlador = 0;
                while(controlador !=9){
                    System.out.println("Deseja adicionar ou remover corretores da transacao?");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Remover");
                System.out.println("9 - Sair");
                controlador = sc.nextInt();
                if(controlador==1){
                    adicionarCorretor(corretores);
                }else if(controlador==2){
                    removerCorretor(corretores);
                }
            }
            break;
        }
    }
    
    private static void adicionarCorretor(HashMap<Integer,Corretor> corretores){
        System.out.println("Informe o codigo do corretor:");
        sc.nextLine();
        int codigo = sc.nextInt();
        corretores.put(codigo,CorretorControl.read(codigo));
    }
    private static void removerCorretor(HashMap<Integer,Corretor> corretores){
        System.out.println("Informe o codigo do corretor:");
        sc.nextLine();
        int codigo = sc.nextInt();
        corretores.remove(codigo);
    }
}
