package com.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class VendaTest {

    @Test
    public void testConstrutorComParametros() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "ISBN0239183091", "Crime e Castigo", 623);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 1, 50.5);
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 3);

        String nomeCliente = "João";
        String formaPagamento = "Cartão";
        double valorDado = 1.0;
        List<LivroVenda> livros = new ArrayList<>();
        livros.add(livroVenda);

        Venda venda = new Venda(nomeCliente, formaPagamento, valorDado, livros);
        Assert.assertNotNull(venda.nomeCliente);
        Assert.assertNotNull(venda.formaPagamento);
        Assert.assertEquals(valorDado, venda.valorDado, 0.001);
        Assert.assertNotNull(venda.livros);
    }
}
