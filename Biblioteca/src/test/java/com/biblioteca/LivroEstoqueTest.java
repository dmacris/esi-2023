package com.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LivroEstoqueTest {

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
    public void testConstrutorComParametros() {
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        Assert.assertEquals(livro, livroEstoque.livro);
        Assert.assertEquals(10, livroEstoque.exemplares);
        Assert.assertEquals(50.0, livroEstoque.valor, 0.01);
    }

    @Test
    public void testConstrutorPadrao() {
        LivroEstoque estoquePadrao = new LivroEstoque();
        Assert.assertNull(estoquePadrao.livro);
        Assert.assertEquals(0, estoquePadrao.exemplares);
        Assert.assertEquals(0.0, estoquePadrao.valor, 0.01);
    }

    @Test
    public void testIncrementarExemplar() {
        livroEstoque.IncrementarExemplar();
        Assert.assertEquals(11, livroEstoque.exemplares);
        Assert.assertEquals(50.0, livroEstoque.valor, 0.01);
    }

    @Test
    public void testDecrementarExemplarComExemplaresDisponiveis() {
        Assert.assertTrue(livroEstoque.DecrementarExemplar());
        Assert.assertEquals(9, livroEstoque.exemplares);
        Assert.assertEquals(50.0, livroEstoque.valor, 0.01);
    }

    @Test
    public void testDecrementarExemplarSemExemplaresDisponiveis() {
        LivroEstoque semEstoque = new LivroEstoque();
        Assert.assertFalse(semEstoque.DecrementarExemplar());
        Assert.assertEquals(0, semEstoque.exemplares);
        Assert.assertEquals(0, semEstoque.valor, 0.01);
    }
}
