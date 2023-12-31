/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Control;

import java.util.HashMap;
import java.util.Scanner;
import trabalho.Model.Cliente;
import trabalho.Model.Imovel;
import trabalho.Model.Vendedor;

/**
 *
 * @author gabri
 */
public class VendedorControl {
    static HashMap<String,Vendedor> vendedores = new HashMap<String,Vendedor>();
    static Scanner sc = new Scanner(System.in);
    public static Vendedor create(){
        System.out.print("Informe o CPF: ");
        sc.nextLine();
        String cpf = sc.nextLine();
        System.out.print("Informe o Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Informe o Email: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Informe o Telefone: ");
        sc.nextLine();
        String telefone = sc.nextLine();
        System.out.print("Informe o Endereco: ");
        sc.nextLine();
        String endereco = sc.nextLine();
        Vendedor vendedor = new Vendedor(cpf, email, nome, endereco, telefone);
        int controlador = 0;
        HashMap<Integer,Imovel> imoveis = new HashMap();
        while(controlador !=9){
            System.out.println("Deseja adicionar ou remover imoveis do vendedor?");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("9 - Sair");
            controlador = sc.nextInt();
            if(controlador==1){
                adicionarImovel(imoveis);
            }else if(controlador==2){
                removerImovel(imoveis);
            }
        }
        vendedor.setImoveis(imoveis);
        vendedores.put(cpf, vendedor);
        return vendedor;
    }
    public static Vendedor read(String CPF){
        return vendedores.get(CPF);
    }
    public static HashMap<String,Vendedor> readAll(){
        return vendedores;
    }
    public static void update(String CPF){
        Vendedor vendedor = vendedores.get(CPF);
        int indice = 0;
        System.out.println("Informe o que será alterado:");
        System.out.println("1:CPF.");
        System.out.println("2:Nome.");
        System.out.println("3:Email.");
        System.out.println("4:Telefone.");
        System.out.println("5:Endereco.");
        System.out.println("6:Lista dos imoveis.");
        indice = sc.nextInt();
        switch(indice){
        case 1:
            System.out.print("Informe o CPF: ");
            sc.nextLine();
            String cpf = sc.nextLine();
            vendedor.setCPF(cpf);
            vendedores.remove(CPF);
            vendedores.put(cpf, vendedor);
            break;
        case 2:
            System.out.print("Informe o Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            vendedor.setNome(nome);
            break;
        case 3: 
            System.out.print("Informe o Email: ");
            sc.nextLine();
            String email = sc.nextLine();
            vendedor.setEmail(email);
            break;
        case 4:
            System.out.print("Informe o Telefone: ");
            sc.nextLine();
            String telefone = sc.nextLine();
            vendedor.setTelefone(telefone);
            break;
        case 5:
            System.out.print("Informe o Endereco: ");
            sc.nextLine();
            String endereco = sc.nextLine();
            vendedor.setEndereço(endereco);
        case 6:
            int controlador = 0;
            while(controlador !=9){
                System.out.println("Deseja adicionar ou remover imoveis do vendedor?");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Remover");
                System.out.println("9 - Sair");
                controlador = sc.nextInt();
                if(controlador==1){
                    adicionarImovel(vendedor.getImoveis());
                }else if(controlador==2){
                    removerImovel(vendedor.getImoveis());
                }
            }
            break;
        }
    }
    public static void delete(String CPF){
        vendedores.remove(CPF);
    }
    private static void adicionarImovel(HashMap<Integer,Imovel> imoveis){
        System.out.println("informe o codigo do imovel");
        int codigo = sc.nextInt();
        if(ImovelControl.read(codigo) == null){
            imoveis.put(codigo,ImovelControl.create()); 
        }
        else imoveis.put(codigo, ImovelControl.read(codigo));
       
    }
    private static void removerImovel(HashMap<Integer,Imovel> imoveis){
        System.out.println("informe o codigo do imovel");
        int codigo = sc.nextInt();
        imoveis.remove(codigo);
    }
}

