/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.Model;

/**
 *
 * @author gabri
 */
public class Imovel {
    private int codigo;
    private String modo;
    private Vendedor dono;
    private String endereco;
    private String tipo;
    private int quartos;
    private float valor;
    private boolean vendido = false;

    public Imovel(int codigo, String modo, Vendedor dono, String endereco, String tipo, int quartos, float valor) {
        this.codigo = codigo;
        this.modo = modo;
        this.dono = dono;
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Vendedor getDono() {
        return dono;
    }

    public void setDono(Vendedor dono) {
        this.dono = dono;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
}
