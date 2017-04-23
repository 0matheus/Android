package matheuslino.com.coeficientepartidario;

/**
 * Created by mathe on 23/04/2017.
 * <p>
 * O coeficiente eleitoral é calculado da seguinte forma:
 * <p>
 * QE = VV/NV.
 * <p>
 * Onde:
 * QE = Quociente Eleitoral
 * VV = Quantidade de votos válidos
 * NV = Número de vagas oferecidas nas eleições
 * VV = V – B – N
 * V = Número de votantes
 * B = Número de votos em branco
 * N = Número de votos nulos
 * <p>
 * Número de vagas para cada partido/coligação é definido da seguinte forma:
 * <p>
 * VG=VP/QE.
 * <p>
 * Onde:
 * VG = Vagas obtidas pelos partidos/coligações
 * VP = Quantidade de votos obtidos pelos partidos/coligações
 * A seguir é apresentado um exemplo de como calcular as vagas para cada
 * partido/coligação.
 */

public class Eleicao {

    private Votacao votacao;
    private int quocienteEleitoral;
    private int votosValidos;
    private int vagasP1;
    private int vagasP2;
    private int vagasP3;


    public Eleicao(Votacao votacao) {
        this.votacao = votacao;
    }

    public void calcular() {
        votosValidos = ((votacao.getVotantes() - votacao.getBrancos()) - votacao.getNulos());
        quocienteEleitoral = Math.round(votosValidos / votacao.getVagas());
        vagasP1 = votacao.getVotosP1() / quocienteEleitoral;
        vagasP2 = votacao.getVotosP2() / quocienteEleitoral;
        vagasP3 = votacao.getVotosP3() / quocienteEleitoral;
        int vagasRemanescentes = votacao.getVagas() - vagasP1 - vagasP2 - vagasP3;
        calcularRemanescentes(vagasRemanescentes);
    }

    private void calcularRemanescentes(int vr) {
        double mediaRP1 = (votacao.getVotosP1() / (vagasP1+1));
        double mediaRP2 = (votacao.getVotosP2() / (vagasP2+1));
        double mediaRP3 = (votacao.getVotosP3() / (vagasP3+1));
//        maiorMedia(mediaRP1, mediaRP2, mediaRP3);

    }

    private void maiorMedia(double mP1, double mP2, double mP3) {
    }


    public Votacao getVotacao() {
        return votacao;
    }

    public void setVotacao(Votacao votacao) {
        this.votacao = votacao;
    }

    public int getQuocienteEleitoral() {
        return quocienteEleitoral;
    }

    public void setQuocienteEleitoral(int quocienteEleitoral) {
        this.quocienteEleitoral = quocienteEleitoral;
    }

    public int getVotosValidos() {
        return votosValidos;
    }

    public void setVotosValidos(int votosValidos) {
        this.votosValidos = votosValidos;
    }

    public int getVagasP1() {
        return vagasP1;
    }

    public void setVagasP1(int vagasP1) {
        this.vagasP1 = vagasP1;
    }

    public int getVagasP2() {
        return vagasP2;
    }

    public void setVagasP2(int vagasP2) {
        this.vagasP2 = vagasP2;
    }

    public int getVagasP3() {
        return vagasP3;
    }

    public void setVagasP3(int vagasP3) {
        this.vagasP3 = vagasP3;
    }
}
