<div align="center"><h1><strong>Conversor de Unidades</strong></h1></div>

Este projeto é uma aplicação Java desenvolvida usando o framework **Java Swing**, que foi utilizado para construir a interface gráfica. O conversor possui a conversão de valores entre diversas unidades, incluindo unidades monetárias. A conversão das unidades monetárias é realizada em tempo real com base nos dados recebidos da API **https://api.invertexto.com/**.

<div align="center"><i>Interface da aplicação</i><br><img width="500" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/750d3c82-5385-4d16-b5af-8ee7646da915"></div>

## Pré-requisitos
Essas instruções serão necessárias para rodar o programa ou modificá-lo.

 * Comece instalando O JDK. É necessario a [Java 8](https://www.oracle.com/br/java/technologies/downloads/#jdk20-windows) (ou superior) instalada na maquina.
<Br><i>No meu caso, uso Windows, então as configurações estarão focadas para Windows.
<Br>Para mais referências sobre a instalação do Java, você pode acessar este [Link](https://www.treinaweb.com.br/blog/como-instalar-o-java-e-nosso-primeiro-exemplo).</i>

* Após a instalação, abra o prompt de comando e digite os seguintes comandos:
```bash
java --version
javac --version
```
*Isso verifica se a máquina consegue reconhecer o java instalado.*

<br>

**⚠ Se não ocorrer nenhum erro, você pode ignorar os próximos passos, pois a instalação do JDK foi realizada com sucesso.**

<br>

* Definirmos uma varivel de ambiente dentro do sistema com o nome **JAVA_HOME**, usando o caminho da pasta onde foi instalado o JDK como valor.
```bash
setx -m JAVA_HOME "C:\<Caminho>\<do>\<nome-da-pasta-da-jdk>"

< Exemplo >
setx -m JAVA_HOME "C:\Program Files\Java\jdk-20"
```
<img width="500" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/8ae105e6-b21d-4c20-b340-8680de13c966">

<br><br>

 * Por fim, adicionamos o diretório "bin" da pasta da JDK ao **PATH** do sistema, usando a variável criada anteriormente
```bash
setx -m PATH "%PATH%;%JAVA_HOME%\bin"
```
<img width="500" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/d31d6a20-493c-4dfe-9173-eb7d93c951e0">

## Instalação

## Configurando o conversor de moedas
<img width="300" heigth="300" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/9287dd1a-18f3-4b6d-a668-d75af78d3d6b">

Como mencionado anteriormente, o conversor de moedas utiliza uma API. Você precisará gerar um token **[aqui](https://api.invertexto.com/)**.
<br>*O programa em si não depende disso para funcionar!*

**Para gerar a token:**
1. Crie uma conta no site mencionado.
2. Você será direcionado à tela de tokens. Clique no botão "criar token".
3. Você pode seguir a seguinte configuração:
<img width="1000" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/c45b8295-4c16-4c03-ac92-309c366c06ee">

<br><br>

4. O token vai ser gerado. Copie este token para usar no programa.
<img width="1000" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/43b53cb6-2e5f-4417-b2f3-afd9b4b09874">

<br><br>

5. Selecione a unidade "Moeda" e clique no botão "Token" e insira a token gerada.
<img width="300" heigth="300" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/afc6e927-c86f-4ebe-a5f2-ee059fe22193">

## Contribuição

O projeto é de código aberto e as contribuições são bem-vindas! Se você deseja contribuir para o projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para a sua nova funcionalidade ou correção de bug.
3. Envie uma solicitação de pull para o repositório original.

## Observação
Este projeto foi desenvolvido como parte do desafio proposto pela [Alura](https://www.alura.com.br/) em parceria com a [Oracle](https://www.oracle.com/br/), por meio do [Programa ONE](https://www.oracle.com/br/education/oracle-next-education/). Inicialmente, o conversor tinha o foco exclusivo na *conversão de moedas*. Por esse motivo, eu criei duas versões: a **versão principal**, que segue o modelo do desafio proposto, e a **versão alternativa (alt)**, que foi documentada neste repositório.

A diferença da **versão original** é a seguinte:

1. Apenas duas opções de conversão disponíveis: Moeda e temperatura.
2. Valor de conversão monetário é fixo.
3. Interface simplificada.

A versão original foi feita para atender aos requisitos do desafio proposto pela Alura e Oracle. Embora a versão original tenha menos funcionalidades, ela mantém a capacidade de realizar conversões monetárias.
<div align="center"><i>Interface da aplicação</i><br><img width="500" heigth="500" src="https://github.com/carlosnet85/one-challenge-convesor-de-moeda/assets/54481508/2e924544-589d-491a-8d5b-3ed3887ff9a4"></div>
