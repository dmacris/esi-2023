# ESI 2023
Resposiório para estudos da disciplina ACH2006 - Engenharia de Sistemas de Informação I (2023) da EACH USP

### Pull Requests
Em uma primeira atividade, envolvendo os conceitos de DevOps (apresentação disponível [neste link](https://www.canva.com/design/DAFxGt3PCcs/zKXuvtY7jN4bB-l_0NFTzw/edit?utm_content=DAFxGt3PCcs&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)) configuramos algumas funcionalidades que o GIT fornece para garantir um pipeline confiável de CI/CD (Continuous Integration/Continuous Delivery. Por isso, sempre que um PR ocorre é disparado um job de CI que verifica se, para além do build estar ok, os testes de unidade estão rodando 100% também para viabilizar o merge.

### Verificar cobertura de Testes com Jacoco
Seguindo para os estudos sobre Testes Automatizados e Cobertura de Testes, utilizamos o [JUnit](https://junit.org/junit5/) nas classes de teste e, para verificar cobertura, contamos com o plugin do [JaCoCo](https://www.baeldung.com/jacoco). A seguir é apresentado como gerar o report para monitoria em seu ambiente local. É importante lembrar que este passo será feito no pipeline de CI automaticamente.

1. Certifique-se que no pom.xml já o plugin do jacoco
2. Para gerar a /target, rode:
```bash
 mvn package
```
3. [prepare-agent] Rode o seguinte comando para gerar o arquivo jacoco.exec na pasta target, lembrando de substituir o <relative-path> relativo ao projeto do IMC ou Biblioteca
```bash
 mvn test -f "<relative-path>\pom.xml"
```
4.[report] Rode o seguinte comando para gerar o report (a relatórios de cobertura de código a partir
   dos dados de execução registrados pelo agente da JaCoCo)
```bash
mvn org.jacoco:jacoco-maven-plugin:0.8.7:report -Djacoco.dataFile=jacoco.exec
```
Por padrão, os dados de execução são lidos no arquivo target/jacoco.exec e o relatório de cobertura de código é gravado no
diretório target/site/jacoco/index.html.
Esse passo 3 é o que devemos incluir no CI.
4. Para visualizar o report, no seu navegador de preferência coloque o caminho do arquivo index.html como url (```<relative-path>\target\site\jacoco\index.html```)

### É possível obter cobertura de 100%?
Acesse a reflexão sobre a pergunta no arquivo desafio-cobertura_100.md na raiz do projeto


##### Referências
https://www.youtube.com/watch?v=E5KMvKrs89Q