package com.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class LivroVendaTest {
    @Test
    public void testConstrutorPadrao(){
        LivroVenda livroVenda = new LivroVenda();
        Assert.assertNull(livroVenda.livroDoEstoque);
        Assert.assertEquals(0, livroVenda.quantidade);
    }

    @Test
    public void testConstrutorComParametros(){
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 1, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 1);
        Assert.assertEquals(livroVenda.quantidade, 1);
        Assert.assertEquals(livroVenda.livroDoEstoque.livro, livro);
    }

    @Test
    public void testQuantidadeDeVendaNaoDeveSerNegativa(){
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 1, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        Assert.assertFalse(livroVenda.DecrementarQuantidade());
    }

    @Test
    public void testIncrementarQuantidade(){
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 1, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        livroVenda.IncrementarQuantidade();
        Assert.assertEquals(livroVenda.quantidade, 1);
    }

    @Test
    public void testIncrementarQuantidadeMaiorQueUm(){
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 3, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        livroVenda.IncrementarQuantidade(3);
        Assert.assertEquals(livroVenda.quantidade, 3);
    }

    @Test
    public void testDecrementarQuantidade(){
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 1, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 1);
        livroVenda.DecrementarQuantidade();
        Assert.assertEquals(livroVenda.quantidade, 0);
    }
}
