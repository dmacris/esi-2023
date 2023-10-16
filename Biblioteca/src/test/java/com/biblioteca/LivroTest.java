package com.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LivroTest {
    private Autor autor;
    private Editora editora;
    private Livro livro;

    @Before
    public void setup(){
        autor = new Autor("Nome do Autor", "Sobrenome do autor");
        editora = new Editora("Nome da Editora");
        livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
    }

    @Test
    public void testConstrutorComParametros() {
        Assert.assertEquals("Nome do Autor", livro.autor.nome);
        Assert.assertEquals("Nome da Editora", livro.editora.nome);
        Assert.assertEquals("1234567890", livro.isbn);
        Assert.assertEquals("Título do Livro", livro.titulo);
        Assert.assertEquals(200, livro.paginas);
    }

    @Test
    public void testConstrutorPadrao() {
        Livro livroPadrao = new Livro();
        Assert.assertNull(livroPadrao.autor);
        Assert.assertNull(livroPadrao.editora);
        Assert.assertNull(livroPadrao.isbn);
        Assert.assertNull(livroPadrao.titulo);
        Assert.assertEquals(0, livroPadrao.paginas);
    }
}
