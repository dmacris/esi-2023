package com.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LivroVendaTest {
    private Autor autor;
    private Editora editora;
    private Livro livro;
    private LivroEstoque livroEstoque;
    @Before
    public void setup(){
        autor = new Autor("Nome do Autor", "Sobrenome do autor");
        editora = new Editora("Nome da Editora");
        livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        livroEstoque = new LivroEstoque(livro, 10, 50.0);
    }
    @Test
    public void testConstrutorPadrao(){
        LivroVenda livroVenda = new LivroVenda();
        Assert.assertNull(livroVenda.livroDoEstoque);
        Assert.assertEquals(0, livroVenda.quantidade);
    }

    @Test
    public void testConstrutorComParametros(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 1);
        Assert.assertEquals(livroVenda.quantidade, 1);
        Assert.assertEquals(livro, livroVenda.livroDoEstoque.livro);
    }

    @Test
    public void testQuantidadeDeVendaNaoDeveSerNegativa(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        Assert.assertFalse(livroVenda.DecrementarQuantidade());
    }

    @Test
    public void testIncrementarQuantidade(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        livroVenda.IncrementarQuantidade();
        Assert.assertEquals(1, livroVenda.quantidade);
    }

    @Test
    public void testIncrementarQuantidadeMaiorQueUm(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);
        livroVenda.IncrementarQuantidade(3);
        Assert.assertEquals(3, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidade(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 1);
        livroVenda.DecrementarQuantidade();
        Assert.assertEquals(0, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeMaiorQueUm(){
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 3);
        livroVenda.DecrementarQuantidade(2);
        Assert.assertEquals(1, livroVenda.quantidade);
    }
}
