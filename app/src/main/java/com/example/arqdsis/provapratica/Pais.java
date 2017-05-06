package com.example.arqdsis.provapratica;

import java.io.Serializable;

/**
 * Created by jose on 05/05/2017.
 *  * jose bruno januario
 * RA:201517258

 */
public class Pais implements Serializable, Comparable<Pais> {
    private int id;
    private String nome;
    private String capital;
    private String area;
    private String populacao;
    public Pais(){}
    public Pais(int id,String nome, String capital, String area, String populacao) {
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.area = area;
        this.populacao = populacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    /**
     *
     * @param o
     * @return
     *  * jose bruno januario
     * RA:201517258

     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

       Pais pais = (Pais) o;

        if (id != pais.id) return false;
        if (!nome.equals(pais.nome)) return false;
        if (!area.equals(pais.area)) return false;
        if (!nome.equals(pais.capital)) return false;
        return populacao.equals(pais.populacao);

    }

    /**
     *
     * @return
     *  * jose bruno januario
     * RA:201517258

     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nome.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + capital.hashCode();
        result = 31 * result + populacao.hashCode();
        return result;
    }

    /**
     *
     * @return
     *  * jose bruno januario
     * RA:201517258

     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                ", capital='" + capital + '\'' +
                ", email='" + populacao + '\'' +
                '}';
    }


    /**
     *
     * @param pais
     * @return
     *  * jose bruno januario
     * RA:201517258

     */
    @Override
    public int compareTo(Pais pais) {
        return this.nome.compareTo(pais.getNome());
    }

}
